package com.sistema.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
    	        .requestMatchers("/registro/**", "/login").permitAll() // Permite acesso sem autenticação
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/participante/**").hasRole("PARTICIPANTE")
                .anyRequest().permitAll()
            )
            .formLogin(login -> login
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/dashboard", true)
            )
            .logout(logout -> logout.logoutUrl("/logout").permitAll());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
