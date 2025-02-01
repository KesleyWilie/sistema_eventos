// Serviço de Evento
package com.sistema.services;

import com.sistema.models.Evento;
import com.sistema.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> listarEventos() {
        return eventoRepository.findAll();
    }

    public Evento buscarEvento(Long id) {
        return eventoRepository.findById(id).orElse(null);
    }

    public void salvarEvento(Evento evento) {
        eventoRepository.save(evento);
    }

    public void deletarEvento(Long id) {
        eventoRepository.deleteById(id);
    }
}