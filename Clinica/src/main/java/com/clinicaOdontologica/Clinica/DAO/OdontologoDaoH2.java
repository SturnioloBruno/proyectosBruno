package com.clinicaOdontologica.Clinica.DAO;

import com.clinicaOdontologica.Clinica.dominio.Odontologo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/clinica" , "sa", "sa");
    }
    @Override
    public List<Odontologo> listarElementos() {
        Connection connection = null;
        Odontologo odontologo = null;
        List<Odontologo> listaRespuesta = new ArrayList<>();
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM odontologos");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                odontologo = new Odontologo(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4));
                listaRespuesta.add(odontologo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return listaRespuesta;
    }

    @Override
    public Odontologo buscarId(int id) {
        Connection connection = null;
        Odontologo odontologo = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM odontologos WHERE id=?");
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                odontologo = new Odontologo(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return odontologo;
    }

    @Override
    public Odontologo buscarEmail(String email) {
        return null;
    }

    @Override
    public Odontologo guardar(Odontologo elemento) {
        return null;
    }

    @Override
    public Odontologo actualizar(Odontologo elemento) {
        return null;
    }

    @Override
    public void eliminar(int id) {

    }
}
