package com.sistema.config;

//SecurityConfig.java (Configuração de segurança com Spring Security)

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	 @Bean
	 public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	     http
	         .authorizeHttpRequests()
	             .requestMatchers("/admin/**").hasRole("ADMIN")
	             .requestMatchers("/participante/**").hasRole("PARTICIPANTE")
	             .anyRequest().permitAll()
	             .and()
	         .formLogin()
	             .loginPage("/login").permitAll()
	             .defaultSuccessUrl("/dashboard", true)
	             .and()
	         .logout()
	             .logoutUrl("/logout").permitAll();
	     return http.build();
	 }
	
	 @Bean
	 public PasswordEncoder passwordEncoder() {
	     return new BCryptPasswordEncoder();
	 }
	}
