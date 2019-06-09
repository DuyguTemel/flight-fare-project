package com.dtemel.ms.currencyconversionbeta.controller;


import com.dtemel.ms.currencyconversionbeta.models.CurrencyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1")
public class CurrencyConversionController {

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyConverter convertCurrency(@PathVariable String from, @PathVariable String to) {
        CurrencyConverter currencyConverter = new CurrencyConverter(1L, from, to, BigDecimal.valueOf(2L));
        return currencyConverter;
    }
}
