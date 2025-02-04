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
        Evento evento = eventoService.buscarPorId(eventoId).orElseThrow(() -> new IllegalArgumentException("Evento não encontrado"));
        Participante participante = participanteService.buscarPorId(participanteId).orElseThrow(() -> new IllegalArgumentException("Participante não encontrado"));

        Inscricao inscricao = new Inscricao();
        inscricao.setEvento(evento);
        inscricao.setParticipante(participante);
        inscricaoService.salvarInscricao(inscricao);

        return "redirect:/participante/inscricoes/eventos";
    }
}