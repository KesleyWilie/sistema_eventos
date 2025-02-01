package com.sistema.services;

import com.sistema.models.Participante;
import com.sistema.repositories.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ParticipanteService {
    @Autowired
    private ParticipanteRepository participanteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void salvarParticipante(Participante participante) {
        participante.setPassword(passwordEncoder.encode(participante.getPassword()));
        participanteRepository.save(participante);
    }
    
    public List<Participante> listarParticipantes() {
        return participanteRepository.findAll();
    }

    public void excluirParticipante(Long id) {
        participanteRepository.deleteById(id);
    }
}