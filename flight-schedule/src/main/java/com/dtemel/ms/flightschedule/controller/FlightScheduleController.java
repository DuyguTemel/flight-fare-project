package com.dtemel.ms.flightschedule.controller;

import com.dtemel.ms.flightschedule.models.Flight;
import com.dtemel.ms.flightschedule.service.FlightScheduleService;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightScheduleController {

    @Autowired
    private FlightScheduleService flightScheduleService;

    @GetMapping("/from/{from}/to/{to}")
    public List<Flight> getFlights(@PathVariable String from, @PathVariable String to) {
        List<Flight> flightList = flightScheduleService.getFlights(from,to);

        return flightList;
    }

}
