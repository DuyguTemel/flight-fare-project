package com.dtemel.ms.flightschedule.service.impl;

import com.dtemel.ms.flightschedule.dao.FlightScheduleRepository;
import com.dtemel.ms.flightschedule.models.Flight;
import com.dtemel.ms.flightschedule.service.FlightScheduleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RefreshScope
public class FlightScheduleServiceImpl implements FlightScheduleService {

    @Value("${airline.disabled}")
    private String airlineDisabled;

    @Autowired
    FlightScheduleRepository flightScheduleRepository;

    @Override
    public List<Flight> getFlights(String from, String to) {

        Flight flight = new Flight();
        flight.setFlightFrom(from);
        flight.setFlightTo(to);
        Example<Flight> flightFilter = Example.of(flight);


        List<Flight> flightList = flightScheduleRepository.findAll(flightFilter);
        if (!CollectionUtils.isEmpty(flightList)) {
            flightList = flightList.stream().filter(flight1 -> !airlineDisabled.equals(flight1.getAirline())).collect(Collectors.toList());
        }
        return flightList;

    }
}
