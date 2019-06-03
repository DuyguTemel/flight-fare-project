package com.dtemel.ms.currencyconversion.controller;


import com.dtemel.ms.currencyconversion.dao.CurrencyConversionRepository;
import com.dtemel.ms.currencyconversion.models.CurrencyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.format.number.money.CurrencyUnitFormatter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CurrencyConversionController {

    @Autowired
    private CurrencyConversionRepository currencyConversionRepository;

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyConverter convertCurrency(@PathVariable String from, @PathVariable String to) {
        CurrencyConverter currencyConverter = new CurrencyConverter(null, from, to, null);
        Example<CurrencyConverter> conversionFilter = Example.of(currencyConverter);

        return currencyConversionRepository.findOne(conversionFilter).get();
    }
}
