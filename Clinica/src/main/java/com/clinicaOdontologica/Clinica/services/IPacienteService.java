package com.clinicaOdontologica.Clinica.services;

import com.clinicaOdontologica.Clinica.dominio.Paciente;

import java.util.List;

public interface IPacienteService {
    List<Paciente> listarPacientes();
    Paciente buscarXEmail(String email);
    Paciente guardar(Paciente paciente);
    Paciente actualizar(Paciente paciente);
    Paciente buscar(Integer id);
    void eliminar(Integer id);
}
