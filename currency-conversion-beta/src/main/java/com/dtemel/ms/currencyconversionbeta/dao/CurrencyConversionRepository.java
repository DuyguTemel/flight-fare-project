package com.dtemel.ms.currencyconversionbeta.dao;

import com.dtemel.ms.currencyconversionbeta.models.CurrencyConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyConversionRepository extends JpaRepository<CurrencyConverter,Long> {
}
