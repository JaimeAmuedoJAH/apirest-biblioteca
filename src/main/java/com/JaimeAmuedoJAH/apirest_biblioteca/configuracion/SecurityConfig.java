package com.JaimeAmuedoJAH.apirest_biblioteca.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Clase de configuración de seguridad para la API REST.
 *
 * Define la seguridad básica utilizando Spring Security,
 * controlando accesos y autenticación de los endpoints.
 *
 * Aquí se pueden configurar políticas como CORS, CSRF, y permisos de acceso
 * a los recursos de la aplicación.
 */

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());

        return http.build();
    }
}


