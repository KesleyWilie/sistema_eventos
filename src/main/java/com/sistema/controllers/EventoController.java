package com.sistema.controllers;

import com.sistema.models.Evento;
import com.sistema.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/eventos")
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @GetMapping
    public String listarEventos(Model model) {
        model.addAttribute("eventos", eventoService.listarEventos());
        return "eventos/listar";
    }

    @GetMapping("/novo")
    public String novoEventoForm(Model model) {
        model.addAttribute("evento", new Evento());
        return "eventos/formulario";
    }

    @PostMapping("/salvar")
    public String salvarEvento(@Valid @ModelAttribute Evento evento, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("evento", evento);
            return "eventos/formulario";
        }
        eventoService.salvarEvento(evento);
        return "redirect:/admin/eventos";
    }

    @GetMapping("/editar/{id}")
    public String editarEventoForm(@PathVariable Long id, Model model) {
        Evento evento = eventoService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Evento não encontrado."));
        model.addAttribute("evento", evento);
        return "eventos/formulario";
    }

    @PostMapping("/deletar/{id}")
    public String deletarEvento(@PathVariable Long id) {
        eventoService.deletarEvento(id);
        return "redirect:/admin/eventos";
    }
}