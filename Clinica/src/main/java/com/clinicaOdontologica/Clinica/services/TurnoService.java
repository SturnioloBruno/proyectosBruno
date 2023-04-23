package com.clinicaOdontologica.Clinica.services;

import com.clinicaOdontologica.Clinica.DAO.IDao;
import com.clinicaOdontologica.Clinica.dominio.Turno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
