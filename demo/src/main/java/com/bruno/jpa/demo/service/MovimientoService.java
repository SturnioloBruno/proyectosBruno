package com.bruno.jpa.demo.service;

import com.bruno.jpa.demo.entities.Movimiento;
import com.bruno.jpa.demo.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoService {
    @Autowired
    MovimientoRepository repository;

    public List<Movimiento> obtenerTodos() {
        return repository.findAll();
    }

    public String guardar(Movimiento m) {
        if (repository.save(m) != null){
            return "Okey";
        }else {
            return null;
        }
        //smell code detected XD
    }
}
