package org.example.dao.impl;

import org.example.dao.IDAO;
import org.example.models.Medicamento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicamentoDaoH2 implements IDAO<Medicamento> {
    public Medicamento guardar(Medicamento medicamento) {
        Connection connection=null;

        try {

            //conectarnos a la base
            connection=getConnection();

            //preparar la operacion de guardado de un medicamento
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO medicamentos (nombre, laboratorio, cantidad, precio) VALUES (?,?,?,?)");
            preparedStatement.setString(1, medicamento.getNombre());
            preparedStatement.setString(2, medicamento.getLaboratorio());
            preparedStatement.setInt(3, medicamento.getCantidad());
            preparedStatement.setDouble(4,medicamento.getPrecio());

            //ejecutar
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return medicamento;
    }

    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/DAO","sa","");
    }
}
