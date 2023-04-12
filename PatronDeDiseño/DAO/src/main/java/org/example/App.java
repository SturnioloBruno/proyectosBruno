package org.example;

import org.example.bd.BD;
import org.example.dao.impl.MedicamentoDaoH2;
import org.example.models.Medicamento;
import org.example.service.MedicamentoService;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoDaoH2());
        try {
            BD.crearBD();
            Medicamento medicamento = new Medicamento("Ibuprofeno FORTE", "lab123", 4,658.5, 51);
            medicamentoService.guardar(medicamento);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
