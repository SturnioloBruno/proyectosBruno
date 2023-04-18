package com.clinicaOdontologica.Clinica.DAO;

import java.util.List;

public interface IDao<T> {
    List<T> listarElementos();
    T buscarId(int id);
    T buscarEmail(String email);
}
