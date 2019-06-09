package com.dtemel.ms.zuulservicegateway;

import com.dtemel.ms.zuulservicegateway.filters.AuthenticationFilter;
import com.dtemel.ms.zuulservicegateway.filters.ResponseAuditFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
//@EnableZuulServer
public class ZuulServiceGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulServiceGatewayApplication.class, args);
	}

}
