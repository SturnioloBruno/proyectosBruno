package com.clinicaOdontologica.Clinica.DAO;

import com.clinicaOdontologica.Clinica.dominio.Domicilio;
import com.clinicaOdontologica.Clinica.dominio.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDaoH2 implements IDao<Paciente> {
    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/clinica" , "sa", "sa");
    }
    @Override
    public List<Paciente> listarElementos() {
        Connection connection = null;
        List<Paciente> listaPacientes = new ArrayList<>();
        Paciente paciente = null;
        Domicilio domicilio = null;

        try {
            DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pacientes");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id_dom = rs.getInt(7);
                domicilio = domicilioDaoH2.buscarId(id_dom);
                paciente = new Paciente(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4), rs.getInt(5),rs.getDate(6).toLocalDate(),domicilio );
            }
        }catch (Exception e){

        }finally {
            try {
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return listaPacientes;
    }

    @Override
    public Paciente buscarId(int id) {
        return null;
    }

    @Override
    public Paciente buscarEmail(String email) {
        return null;
    }
}
