package com.dtemel.ms.flightschedule.service;

import com.dtemel.ms.flightschedule.models.Flight;

import java.util.List;

public interface FlightScheduleService {
    List<Flight> getFlights(String from,String to);
}
