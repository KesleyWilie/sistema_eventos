package com.sistema.services;

import com.sistema.models.Administrador;
import com.sistema.repositories.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService {
    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void salvarAdministrador(Administrador administrador) {
        administrador.setPassword(passwordEncoder.encode(administrador.getPassword()));
        administradorRepository.save(administrador);
    }

    public List<Administrador> listarAdministradores() {
        return administradorRepository.findAll();
    }

    public void excluirAdministrador(Long id) {
        administradorRepository.deleteById(id);
    }
}