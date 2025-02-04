package com.sistema.controllers;

import com.sistema.models.Administrador;
import com.sistema.models.Participante;
import com.sistema.services.AdministradorService;
import com.sistema.services.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistroController {

    @Autowired
    private AdministradorService administradorService;

    @Autowired
    private ParticipanteService participanteService;

    // Página de registro para administradores
    @GetMapping("/registro/admin")
    public String registroAdminForm(Model model) {
        model.addAttribute("administrador", new Administrador());
        return "registro/admin";
    }

    @PostMapping("/registro/admin")
    public String registrarAdmin(Administrador administrador) {
        administradorService.salvarAdministrador(administrador);
        return "redirect:/login";
    }

    // Página de registro para participantes
    @GetMapping("/registro/participante")
    public String registroParticipanteForm(Model model) {
        model.addAttribute("participante", new Participante());
        return "registro/participante";
    }

    @PostMapping("/registro/participante")
    public String registrarParticipante(Participante participante) {
        participanteService.salvarParticipante(participante);
        return "redirect:/login";
    }
}