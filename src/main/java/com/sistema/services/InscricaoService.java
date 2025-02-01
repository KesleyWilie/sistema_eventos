package com.sistema.services;

import com.sistema.models.Inscricao;
import com.sistema.repositories.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscricaoService {
    @Autowired
    private InscricaoRepository inscricaoRepository;

    public void salvarInscricao(Inscricao inscricao) {
        inscricaoRepository.save(inscricao);
    }
}