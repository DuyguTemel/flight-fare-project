package com.dtemel.ms.zuulservicegateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import java.io.IOException;
import java.util.logging.Filter;

public class RouteFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterUtils.ROUTE_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("Routing Filter is invoked");
        RequestContext ctx = RequestContext.getCurrentContext();
        Object serviceId = ctx.get("serviceId");
        if (serviceId.toString().equals(FilterUtils.CURRENCY_CONVERSION_SERVICE_NAME)) {
            boolean usenewroute = FilterUtils.useNewRoute();
            if (usenewroute) {
                String oldEndpoint = ctx.getRequest().getRequestURI();
                String newEndpoint = "/flights/currency-conversıon-beta";

                int index = oldEndpoint.indexOf("cc");
                String strippedRoute = oldEndpoint.substring(index + "cc".length());
                String route = String.format("%s%s", newEndpoint, strippedRoute);
                System.out.println("New route to call" + route);
//disable SimpleHostRoutingFilter
                ctx.setRouteHost(null);
// disable RibbonRouting Filter
                ctx.remove(serviceId);

                try {
                    RequestContext.getCurrentContext().getResponse().sendRedirect(route);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
