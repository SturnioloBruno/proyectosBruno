package com.clinicaOdontologica.Clinica.DAO;

import java.util.List;

public interface IDao<T> {
    List<T> listarElementos();
    T buscarId(int id);
    T buscarEmail(String email);
    T guardar(T elemento);
    T actualizar(T elemento);
    void eliminar(int id);
}
