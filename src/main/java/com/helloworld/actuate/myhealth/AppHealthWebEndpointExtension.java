package com.helloworld.actuate.myhealth;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.boot.actuate.health.Health;

@EndpointWebExtension(endpoint = AppHealthEndpoint.class)
public class AppHealthWebEndpointExtension {

    private final AppHealthEndpoint delegate;

    public AppHealthWebEndpointExtension(AppHealthEndpoint delegate) {
        this.delegate = delegate;
    }

    @ReadOperation
    public WebEndpointResponse<Health> getHealth() {
        Health health = delegate.health();
        return new WebEndpointResponse<>(health, 200);
    }
}
