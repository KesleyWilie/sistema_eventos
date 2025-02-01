// Configuração para criar administrador padrão ao inicializar
package com.sistema.config;

import com.sistema.models.Administrador;
import com.sistema.repositories.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminInitializer {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner initAdmin(AdministradorRepository adminRepo) {
        return args -> {
            if (adminRepo.findByUsername("admin@admin.com").isEmpty()) {
                Administrador admin = new Administrador();
                admin.setUsername("admin@admin.com");
                admin.setPassword(passwordEncoder.encode("admin123"));
                adminRepo.save(admin);
            }
        };
    }
}