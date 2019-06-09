package com.dtemel.ms.currencyconversionbeta;

import com.dtemel.ms.currencyconversionbeta.dao.CurrencyConversionRepository;
import com.dtemel.ms.currencyconversionbeta.models.CurrencyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BootstrapRepository implements CommandLineRunner {

    @Autowired
    private CurrencyConversionRepository conversionRepository;

    @Override
    public void run(String... args) throws Exception {
        CurrencyConverter currencyConverter = new CurrencyConverter(1L,"USD","EURO", BigDecimal.valueOf(74.10));
        CurrencyConverter currencyConverter2 = new CurrencyConverter(2L, "USD","TL", BigDecimal.valueOf(0.76));
        CurrencyConverter currencyConverter3 = new CurrencyConverter(3L, "USD","YEN", BigDecimal.valueOf(22.50));

        conversionRepository.save(currencyConverter);
        conversionRepository.save(currencyConverter2);
        conversionRepository.save(currencyConverter3);


    }
}
