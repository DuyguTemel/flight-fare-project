package com.dtemel.ms.flightfare.controller;

import com.dtemel.ms.flightfare.dao.FlightFareRepository;
import com.dtemel.ms.flightfare.models.CurrencyConversion;
import com.dtemel.ms.flightfare.models.FlightFare;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/flight/{flightCode}/fare/{currency}")
public class FlightFareController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private FlightFareRepository flightFareRepository;

    @Value("${base.curreny:USD}")
    private String baseCurrency;

    @GetMapping
    public FlightFare getSingleTicket(@PathVariable String flightCode, @PathVariable String currency) {
        FlightFare flightFare = getFlightFare(flightCode);
        flightFare.setCurrency(currency);
        if (!baseCurrency.equals(currency)) {
            BigDecimal conversionRate = this.getConversion(currency);
            BigDecimal convertedFare = flightFare.getFlightFare().multiply(conversionRate);
            flightFare.setFlightFare(convertedFare);
        }
        return flightFare;
    }


    public FlightFare getFlightFare(String flightCode) {
        FlightFare flightFare = new FlightFare(null, flightCode, null, null);
        Example<FlightFare> flightFareFilter = Example.of(flightFare);
        FlightFare fare = flightFareRepository.findOne(flightFareFilter).get();
        return fare;
    }

    private BigDecimal getConversion(String toCurrency) {
//        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> urlPathVariable = new HashMap<>();
        urlPathVariable.put("from", baseCurrency);
        urlPathVariable.put("to", toCurrency);

        ResponseEntity<CurrencyConversion> responseEntity = restTemplate.getForEntity("http://currency-conversion/api/v1/from/{from}/to/{to}", CurrencyConversion.class, urlPathVariable);
        return responseEntity.getBody().getConversionRate();
    }
}
