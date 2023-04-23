package com.clinicaOdontologica.Clinica.controller;

import com.clinicaOdontologica.Clinica.DAO.OdontologoDaoH2;
import com.clinicaOdontologica.Clinica.DAO.PacienteDaoH2;
import com.clinicaOdontologica.Clinica.DAO.TurnoLista;
import com.clinicaOdontologica.Clinica.dominio.Odontologo;
import com.clinicaOdontologica.Clinica.dominio.Paciente;
import com.clinicaOdontologica.Clinica.dominio.Turno;
import com.clinicaOdontologica.Clinica.services.OdontologoService;
import com.clinicaOdontologica.Clinica.services.PacienteService;
import com.clinicaOdontologica.Clinica.services.TurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private TurnoService turnoService = new TurnoService(new TurnoLista());
    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2());
    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());
    @GetMapping
    public ResponseEntity<List<Turno>> listarTurnos() {
        return ResponseEntity.ok(turnoService.listar());
    }

    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno) {
        ResponseEntity<Turno> respuesta;
        // controlar si los id son existentes
        Paciente paciente = pacienteService.buscar(turno.getPaciente().getId());
        Odontologo odontologo = odontologoService.buscar(turno.getOdontologo().getId());
        // control
        if ( paciente != null && odontologo != null ) {
            // okey, podemos agregar el turno
            respuesta = ResponseEntity.ok(turnoService.registrarTurno(turno));
        }
        else {
            respuesta = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return respuesta;
    }
}
