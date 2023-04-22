package com.clinicaOdontologica.Clinica.controller;

import com.clinicaOdontologica.Clinica.dominio.Paciente;
import com.clinicaOdontologica.Clinica.services.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private final IPacienteService pacienteService;

    @Autowired
    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/index")
    public String traerPaciente(Model model, @RequestParam("email") String email) {
        // buscar el paciente con el email
        Paciente paciente = pacienteService.buscarXEmail(email);
        model.addAttribute("nombre", paciente.getNombre());
        model.addAttribute("apellido", paciente.getApellido());
        return "index";
    }

    @PostMapping
    public Paciente registrarPaciente(@RequestBody Paciente paciente){
        return pacienteService.guardar(paciente);
    }

    @PutMapping
    public Paciente actualizarPaciente(@RequestBody Paciente paciente) {
        return pacienteService.actualizar(paciente);
    }

    @GetMapping("/{id}")
    public Paciente buscarPaciente(@PathVariable Integer id) {
        return pacienteService.buscar(id);
    }

    @DeleteMapping("/{id}")
    public String eliminarPaciente(@PathVariable Integer id) {
        String resp = "Error el id ingresado no es correcto";
        if (pacienteService.buscar(id) != null){
            pacienteService.eliminar(id);
            resp = "Se elimino al paciente con id=" + id;
        }
        return resp;
    }

    @GetMapping
    public List<Paciente> listarPacientes() {
        return pacienteService.listarPacientes();
    }
}
