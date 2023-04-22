package com.clinicaOdontologica.Clinica.services;

import com.clinicaOdontologica.Clinica.DAO.IDao;
import com.clinicaOdontologica.Clinica.dominio.Odontologo;

import java.util.List;

public class OdontologoService {
    //lo hago sin interfaz, para tener dos ejemplos, con y sin
    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public List<Odontologo> buscarTodos() {
        return odontologoIDao.listarElementos();
    }
}
