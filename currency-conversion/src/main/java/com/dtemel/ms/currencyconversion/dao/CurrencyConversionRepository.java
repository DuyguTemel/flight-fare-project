package com.dtemel.ms.currencyconversion.dao;

import com.dtemel.ms.currencyconversion.models.CurrencyConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyConversionRepository extends JpaRepository<CurrencyConverter,Long> {
}
