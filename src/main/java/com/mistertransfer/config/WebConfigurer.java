package com.mistertransfer.config;


import com.mistertransfer.config.security.CorsConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Configuration of web application with Servlet 3.0 APIs.
 */
@Configuration
public class WebConfigurer implements ServletContextInitializer {

    private final Logger log = LoggerFactory.getLogger(WebConfigurer.class);
    public static final String API_URL = "/api";

    final CorsConfig corsConfig;

    public WebConfigurer(CorsConfig config) {
        this.corsConfig = config;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = corsConfig.corsConfiguration();
        if (!CollectionUtils.isEmpty(config.getAllowedOrigins()) || !CollectionUtils.isEmpty(config.getAllowedOriginPatterns())) {
            log.info("Registering CORS filter");
            source.registerCorsConfiguration(API_URL + "/**", config);
        }
        return new CorsFilter(source);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.info("Web application fully configured");
    }
}
