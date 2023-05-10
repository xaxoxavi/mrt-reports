package com.mistertransfer.reports.domain.config;



import com.mistertransfer.config.WebConfigurer;
import com.mistertransfer.config.security.jwt.JWTConfigurer;
import com.mistertransfer.config.security.jwt.TokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    private final TokenProvider tokenProvider;
    private final String contentSecurityPolicy = "default-src 'self'; frame-src 'self' data:; script-src 'self' 'unsafe-inline' 'unsafe-eval' https://storage.googleapis.com; style-src 'self' 'unsafe-inline'; img-src 'self' data:; font-src 'self' data:";


    public SecurityConfiguration(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf().disable();

        http
                .headers()
                .contentSecurityPolicy(contentSecurityPolicy)
                .and()
                .referrerPolicy(ReferrerPolicyHeaderWriter.ReferrerPolicy.STRICT_ORIGIN_WHEN_CROSS_ORIGIN)
                .and()
                .permissionsPolicy().policy("camera=(), fullscreen=(self), geolocation=(), gyroscope=(), magnetometer=(), microphone=(), midi=(), payment=(), sync-xhr=()")
                .and()
                .frameOptions()
                .deny()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                /*.and()
                .securityMatcher(WebConfigurer.API_URL + "/**")
                .authorizeHttpRequests()
                .requestMatchers(WebConfigurer.API_URL + "/authenticate").permitAll()
                .requestMatchers(WebConfigurer.API_URL + "/availability/").permitAll()
                .requestMatchers(WebConfigurer.API_URL + "/transaction/").permitAll()
                .requestMatchers(WebConfigurer.API_URL + "/reviews/**").permitAll()
                .requestMatchers(WebConfigurer.API_URL + "/searcher/**").permitAll()
                .requestMatchers(WebConfigurer.API_URL + "/admin/**").hasAuthority("ADMIN")
                .requestMatchers(WebConfigurer.API_URL + "/**").authenticated()
                //IMPORTANT: el que hace la autorizacion es: org.springframework.security.web.access.intercept.RequestMatcherDelegatingAuthorizationManager
                // y tb: org.springframework.security.authorization.AuthorityAuthorizationManager
                .and()
                .apply(securityConfigurerAdapter());*/

        return http.build();
    }


    private JWTConfigurer securityConfigurerAdapter() {
        return new JWTConfigurer(tokenProvider);
    }
}
