package com.dtemel.ms.flightschedule.service.impl;

import com.dtemel.ms.flightschedule.dao.FlightScheduleRepository;
import com.dtemel.ms.flightschedule.models.Flight;
import com.dtemel.ms.flightschedule.service.FlightScheduleService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RefreshScope
public class FlightScheduleServiceImpl implements FlightScheduleService {

//    @Value("${airline.disabled}")
    private String airlineDisabled="ESB";

    @Autowired
    FlightScheduleRepository flightScheduleRepository;

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="7000")
    })
    @Override
    public List<Flight> getFlights(String from, String to) {

        Flight flight = new Flight();
        flight.setFlightFrom(from);
        flight.setFlightTo(to);
        Example<Flight> flightFilter = Example.of(flight);
        sleepRandomly();

        List<Flight> flightList = flightScheduleRepository.findAll(flightFilter);
        if (!CollectionUtils.isEmpty(flightList)) {
            flightList = flightList.stream().filter(flight1 -> !airlineDisabled.equals(flight1.getAirline())).collect(Collectors.toList());
        }
        return flightList;

    }

    public void sleepRandomly() {
        Random rand = new Random();
        int randomNum = rand.nextInt(3) + 1;
        if (randomNum == 3) {
            System.out.println("Hystrix action");

            try {
                System.out.println("Start sleeping.." + System.currentTimeMillis());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
