package com.dtemel.ms.flightschedule.dao;

import com.dtemel.ms.flightschedule.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightScheduleRepository extends JpaRepository<Flight, Long> {
}
