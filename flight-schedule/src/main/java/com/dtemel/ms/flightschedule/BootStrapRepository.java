package com.dtemel.ms.flightschedule;

import com.dtemel.ms.flightschedule.dao.FlightScheduleRepository;
import com.dtemel.ms.flightschedule.models.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapRepository implements CommandLineRunner {

    @Autowired
    private  FlightScheduleRepository flightScheduleRepository;

    @Override
    public void run(String... args) throws Exception {
        Flight flight=new Flight(1L,"UL","Ankara","Istanbul","ESB","11.00","12.00");
        Flight flight2=new Flight(2L,"UL","Ankara2","Istanbul3","ESB","11.20","12.40");
        Flight flight3=new Flight(3L,"UL","Ankara3","Istanbul4","ESB","11.05","12.50");

        flightScheduleRepository.save(flight);
        flightScheduleRepository.save(flight2);
        flightScheduleRepository.save(flight3);


    }
}
