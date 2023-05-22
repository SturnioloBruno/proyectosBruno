package com.example.fixture.service;

import com.example.fixture.model.Partido;
import com.example.fixture.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartidoService {

    @Autowired
    PartidoRepository repository;

    public Partido agregar(Partido partido) {
        return repository.save(partido);
    }
}
