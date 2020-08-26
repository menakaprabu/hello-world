package com.helloworld.config;

import com.helloworld.actuate.myhealth.AppHealthEndpoint;
import com.helloworld.actuate.myhealth.AppHealthWebEndpointExtension;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActuatorConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public AppHealthEndpoint appHealthEndpoint() {
        return new AppHealthEndpoint();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnBean({AppHealthEndpoint.class})
    public AppHealthWebEndpointExtension appHealthWebEndpointExtension(
            AppHealthEndpoint delegate) {
        return new AppHealthWebEndpointExtension(delegate);
    }
}
