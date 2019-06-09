package com.dtemel.ms.greetservice;

import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/name")
public class GreetServiceController {


    @GetMapping(value="/{name}")
    public String greetMe(@PathVariable String name){
        return String.format("Hello %s! How are you?",name );
    }
}
