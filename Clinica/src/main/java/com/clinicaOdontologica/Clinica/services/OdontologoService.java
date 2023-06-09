package com.clinicaOdontologica.Clinica.services;

import com.clinicaOdontologica.Clinica.DAO.IDao;
import com.clinicaOdontologica.Clinica.dominio.Odontologo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {
    //lo hago sin interfaz, para tener dos ejemplos, con y sin
    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public List<Odontologo> buscarTodos() {
        return odontologoIDao.listarElementos();
    }

    public Odontologo buscar(int id) {
        return odontologoIDao.buscarId(id);
    }
}
