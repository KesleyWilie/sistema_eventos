// Controlador de Eventos para Admin
package com.sistema.controllers;

import com.sistema.models.Evento;
import com.sistema.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public String listarEventos(Model model) {
        model.addAttribute("eventos", eventoService.listarEventos());
        return "admin/eventos";
    }

    @GetMapping("/novo")
    public String novoEventoForm(Model model) {
        model.addAttribute("evento", new Evento());
        return "admin/novo_evento";
    }

    @PostMapping
    public String salvarEvento(@ModelAttribute Evento evento) {
        eventoService.salvarEvento(evento);
        return "redirect:/admin/eventos";
    }

    @GetMapping("/editar/{id}")
    public String editarEventoForm(@PathVariable Long id, Model model) {
        model.addAttribute("evento", eventoService.buscarEvento(id));
        return "admin/editar_evento";
    }

    @PostMapping("/editar")
    public String atualizarEvento(@ModelAttribute Evento evento) {
        eventoService.salvarEvento(evento);
        return "redirect:/admin/eventos";
    }

    @PostMapping("/deletar/{id}")
    public String deletarEvento(@PathVariable Long id) {
        eventoService.deletarEvento(id);
        return "redirect:/admin/eventos";
    }
}