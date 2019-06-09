package com.dtemel.ms.zuulservicegateway.filters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulFilters {

    @Bean
    public AuthenticationFilter getAuthenticationFilter(){
        return new AuthenticationFilter();
    }

    @Bean
    public ResponseAuditFilter responseAuditFilter() {
        return new ResponseAuditFilter();
    }

    @Bean
    public RouteFilter routeFilter() {
        return new RouteFilter();
    }

}
