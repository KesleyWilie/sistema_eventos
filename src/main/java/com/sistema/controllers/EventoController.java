package com.sistema.controllers;

import com.sistema.models.Evento;
import com.sistema.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @GetMapping("/admin/eventos")
    public String listarEventos(Model model) {
        model.addAttribute("eventos", eventoService.listarEventos());
        return "eventos/listar";
    }

    @PostMapping("/admin/eventos")
    public String salvarEvento(Evento evento) {
        eventoService.salvarEvento(evento);
        return "redirect:/admin/eventos";
    }
}
