package com.sistema.repositories;

import com.sistema.models.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    Administrador findByUsername(String username);
}