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

    public void salvarEvento(Evento evento) {
        eventoRepository.save(evento);
    }

    public List<Evento> listarEventos() {
        return eventoRepository.findAll();
    }

    public void excluirEvento(Long id) {
        eventoRepository.deleteById(id);
    }
}
