package com.sistema.controllers;

import com.sistema.models.Participante;
import com.sistema.services.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/participantes")
public class ParticipanteController {
    @Autowired
    private ParticipanteService participanteService;

    @GetMapping
    public String listarParticipantes(Model model) {
        model.addAttribute("participantes", participanteService.listarParticipantes());
        return "participantes/listar";
    }

    @PostMapping
    public String salvarParticipante(Participante participante) {
        participanteService.salvarParticipante(participante);
        return "redirect:/admin/participantes";
    }

    @GetMapping("/excluir/{id}")
    public String excluirParticipante(@PathVariable Long id) {
        participanteService.excluirParticipante(id);
        return "redirect:/admin/participantes";
    }
}
