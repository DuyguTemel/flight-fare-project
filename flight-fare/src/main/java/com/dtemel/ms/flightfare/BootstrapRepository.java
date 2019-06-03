package com.dtemel.ms.flightfare;

import com.dtemel.ms.flightfare.dao.FlightFareRepository;
import com.dtemel.ms.flightfare.models.FlightFare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Component
public class BootstrapRepository implements CommandLineRunner {

    @Autowired
    FlightFareRepository flightFareRepository;



    @Override
    public void run(String... args) throws Exception {
        FlightFare flightFare=new FlightFare(1L,"UL-001", BigDecimal.valueOf(1000),"EURO");
        FlightFare flightFare2=new FlightFare(2L,"UL-002", BigDecimal.valueOf(2000),"USD");
        FlightFare flightFare3=new FlightFare(3L,"UL-003", BigDecimal.valueOf(3000),"TL");
        flightFareRepository.save(flightFare);
        flightFareRepository.save(flightFare2);
        flightFareRepository.save(flightFare3);

    }
}
