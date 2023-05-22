package com.example.fixture.controller;

import com.example.fixture.model.Partido;
import com.example.fixture.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

    @Autowired
    PartidoService service;

    @PostMapping
    public Partido registrarPartido(@RequestBody Partido partido){
        return service.agregar(partido);
    }
}
