package com.clinicaOdontologica.Clinica.services;

import com.clinicaOdontologica.Clinica.dominio.Paciente;

import java.util.List;

public interface IPacienteService {
    List<Paciente> listarPacientes();
    Paciente buscarXEmail(String email);
}
