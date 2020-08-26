package com.helloworld.actuate.myhealth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.health.Health;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@Endpoint(id = "healthz")
public class AppHealthEndpoint {

    @Value("${app.version:unknown}")
    private String appVersion;

    private SimpleDateFormat changeFormat = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");

    @ReadOperation
    public Health health() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080";
        try {
            String resp = restTemplate.getForObject(url, String.class);

            if ("Hello!".equalsIgnoreCase(resp)) {

                String date = changeFormat.format(new Date());
                return Health.up().withDetail("status","OK").
                                   withDetail("version",appVersion).
                                   withDetail("uptime",date).
                        build();
            } else {
                return Health.down().withDetail("Status","Down").
                        withDetail("version",appVersion).
                        build();
            }
        } catch (RestClientException e) {
            return Health.down().withDetail("Status","Down").
                    withDetail("version",appVersion).
                    build();
        } catch (Exception e){
            return Health.down().withDetail("Status","Down").
                    withDetail("version",appVersion).
                    build();
        }
    }
}
