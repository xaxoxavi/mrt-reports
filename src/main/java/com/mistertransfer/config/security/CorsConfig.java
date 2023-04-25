package com.mistertransfer.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
public class CorsConfig {

    @Value("#{'${security.cors.allowed-origins}'.split(',')}")
    private List<String> allowedOrigins;

    @Value("#{'${security.cors.allowed-methods}'.split(',')}")
    private List<String> allowedMethods;

    @Value("#{'${security.cors.allowed-headers}'.split(',')}")
    private List<String> allowedHeaders;

    @Value("${security.cors.allow-credentials}")
    private Boolean allowedCredentials;

    @Value("${security.cors.max-age}")
    private Long maxAge;

    @Bean
    public CorsConfiguration corsConfiguration(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(allowedOrigins);
        corsConfiguration.setAllowedHeaders(allowedHeaders);
        corsConfiguration.setAllowedMethods(allowedMethods);

        corsConfiguration.setAllowCredentials(allowedCredentials);
        corsConfiguration.setMaxAge(maxAge);

        return corsConfiguration;
    }




}
