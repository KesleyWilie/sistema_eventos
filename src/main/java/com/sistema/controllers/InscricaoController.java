package com.sistema.controllers;

import com.sistema.models.Evento;
import com.sistema.models.Inscricao;
import com.sistema.models.Participante;
import com.sistema.services.EventoService;
import com.sistema.services.InscricaoService;
import com.sistema.services.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/participante/inscricoes")
public class InscricaoController {
    @Autowired
    private InscricaoService inscricaoService;

    @Autowired
    private EventoService eventoService;

    @Autowired
    private ParticipanteService participanteService;

    @GetMapping("/eventos")
    public String listarEventosParaInscricao(Model model) {
        model.addAttribute("eventos", eventoService.listarEventos());
        return "inscricoes/eventos";
    }

    @PostMapping("/eventos/{eventoId}")
    public String inscreverParticipante(@PathVariable Long eventoId, @RequestParam Long participanteId) {
        Evento evento = eventoService.listarEventos().stream().filter(e -> e.getId().equals(eventoId)).findFirst().orElse(null);
        Participante participante = participanteService.listarParticipantes().stream().filter(p -> p.getId().equals(participanteId)).findFirst().orElse(null);
        
        if (evento != null && participante != null) {
            Inscricao inscricao = new Inscricao();
            inscricao.setEvento(evento);
            inscricao.setParticipante(participante);
            inscricaoService.salvarInscricao(inscricao);
        }

        return "redirect:/participante/inscricoes/eventos";
    }
}