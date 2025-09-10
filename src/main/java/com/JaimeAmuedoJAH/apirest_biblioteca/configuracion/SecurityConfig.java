package com.JaimeAmuedoJAH.apirest_biblioteca.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Desactiva CSRF para POST, PUT, DELETE desde Postman
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated() // Requiere autenticación para todos los endpoints
                )
                .httpBasic(withDefaults()); // Forma recomendada en Spring Security 6.1+

        return http.build();
    }
}


