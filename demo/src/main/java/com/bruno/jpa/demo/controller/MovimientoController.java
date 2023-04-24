package com.bruno.jpa.demo.controller;

import com.bruno.jpa.demo.entities.Movimiento;
import com.bruno.jpa.demo.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {
    @Autowired
    MovimientoService service;

    @GetMapping
    public ResponseEntity<List<Movimiento>> traerTodosMovimientos() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearMovimiento(@RequestBody Movimiento m) {
        ResponseEntity<String> respuesta = null;
        if (service.guardar(m) != null) {
            respuesta = ResponseEntity.ok("El movimiento se cargó con exito");
        }else {
            respuesta = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear el movimiento");

        }
        return respuesta;
    }
}
