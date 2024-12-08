package com.amizhth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig implements WebMvcConfigurer {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Enable CORS in Spring Security
        http.cors().and()  // Enable CORS
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers(HttpMethod.OPTIONS, "**").permitAll()  // Allow OPTIONS requests (CORS pre-flight)
                .requestMatchers("/**").permitAll()  // Allow all other endpoints
                .requestMatchers("/test")
                .access(new WebExpressionAuthorizationManager("hasIpAddress('152.58.199.11') or hasIpAddress('::1')"))
                .anyRequest().authenticated())  // Ensure authentication for other requests

            // Disable session management (stateless API)
            .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

            // Disable CSRF (for stateless API)
            .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable());

        return http.build();
    }

    // Global CORS configuration
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Apply to all paths
                .allowedOrigins("http://127.0.0.1:5500")  // Replace with your frontend URL
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allow specific HTTP methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true);  // Allow credentials (cookies, authorization headers)
    }
}
