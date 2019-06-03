package com.dtemel.ms.flightfare.dao;

import com.dtemel.ms.flightfare.models.FlightFare;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightFareRepository extends JpaRepository<FlightFare, Long> {
}
