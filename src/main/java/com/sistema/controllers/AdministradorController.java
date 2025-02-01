package com.sistema.controllers;

import com.sistema.models.Administrador;
import com.sistema.services.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/administradores")
public class AdministradorController {
    @Autowired
    private AdministradorService administradorService;

    @GetMapping
    public String listarAdministradores(Model model) {
        model.addAttribute("administradores", administradorService.listarAdministradores());
        return "administradores/listar";
    }

    @PostMapping
    public String salvarAdministrador(Administrador administrador) {
        administradorService.salvarAdministrador(administrador);
        return "redirect:/admin/administradores";
    }

    @GetMapping("/excluir/{id}")
    public String excluirAdministrador(@PathVariable Long id) {
        administradorService.excluirAdministrador(id);
        return "redirect:/admin/administradores";
    }
}