package com.clinicaOdontologica.Clinica.controller;

import com.clinicaOdontologica.Clinica.DAO.OdontologoDaoH2;
import com.clinicaOdontologica.Clinica.dominio.Odontologo;
import com.clinicaOdontologica.Clinica.services.OdontologoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private final OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @GetMapping
    public List<Odontologo> buscarTodosOdontologos() {
        return odontologoService.buscarTodos();
    }
    @GetMapping("/{id}")
    public Odontologo buscarPorId(@PathVariable Integer id){
        return odontologoService.buscar(id);
    }
}
