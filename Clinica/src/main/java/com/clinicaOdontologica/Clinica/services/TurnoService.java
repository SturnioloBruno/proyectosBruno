package com.clinicaOdontologica.Clinica.services;

import com.clinicaOdontologica.Clinica.DAO.IDao;
import com.clinicaOdontologica.Clinica.dominio.Turno;

import java.util.List;

public class TurnoService {
    private IDao<Turno> turnoIDao;

    public TurnoService(IDao<Turno> turnoIDao) {
        this.turnoIDao = turnoIDao;
    }

    public Turno registrarTurno(Turno turno) {
        return turnoIDao.guardar(turno);
    }

    public List<Turno> listar() {
        return turnoIDao.listarElementos();
    }
}
