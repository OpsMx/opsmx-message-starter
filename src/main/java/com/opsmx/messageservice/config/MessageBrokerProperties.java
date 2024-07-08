package com.opsmx.messageservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "message-broker")
@EnableConfigurationProperties({MessageBrokerProperties.class, MessageBrokerProperties.Endpoint.class})
public class MessageBrokerProperties {

    private String username;
    private String password;
    private String host;
    private String port;
    private Endpoint endpoint;

    @Data
    @Configuration
    @ConfigurationProperties(prefix = "message-broker.endpoint")
    public static class Endpoint {
        private String name;
    }

}