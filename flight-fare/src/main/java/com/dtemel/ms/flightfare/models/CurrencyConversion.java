package com.dtemel.ms.flightfare.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyConversion {
    private String currencyFrom;
    private String currencyTo;
    private BigDecimal conversionRate;

}
