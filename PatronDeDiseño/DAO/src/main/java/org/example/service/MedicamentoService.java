package org.example.service;

import org.example.dao.IDAO;
import org.example.models.Medicamento;

public class MedicamentoService {
    private IDAO<Medicamento> medicamentoDAO;

    public MedicamentoService(IDAO<Medicamento> medicamentoDAO) {
        this.medicamentoDAO = medicamentoDAO;
    }

    public Medicamento guardar(Medicamento medicamento) {
        return medicamentoDAO.guardar(medicamento);
    }
}
