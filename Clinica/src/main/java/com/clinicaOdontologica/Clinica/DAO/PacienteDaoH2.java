package com.clinicaOdontologica.Clinica.DAO;

import com.clinicaOdontologica.Clinica.dominio.Domicilio;
import com.clinicaOdontologica.Clinica.dominio.Paciente;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
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
                listaPacientes.add(paciente);
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

        Connection connection = null;
        Paciente paciente = null;
        Domicilio domicilio = null;

        try {
            DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pacientes WHERE email LIKE ?");
            preparedStatement.setString(1,email);
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
        return paciente;
    }

    @Override
    public Paciente guardar(Paciente elemento) {
        Connection connection = null;
        try {
            connection = getConnection();
            DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();
            Domicilio domicilio = domicilioDaoH2.guardar(elemento.getDomicilio());
            elemento.getDomicilio().setId(domicilio.getId());

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO pacientes(nombre,apellido,email,dni,fecha_ingreso,domicilio_id) VALUES(?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,elemento.getNombre());
            preparedStatement.setString(2,elemento.getApellido());
            preparedStatement.setString(3, elemento.getEmail());
            preparedStatement.setInt(4,elemento.getDni());
            preparedStatement.setDate(5,Date.valueOf(elemento.getFechaIngreso()));
            preparedStatement.setInt(6,elemento.getDomicilio().getId());

            preparedStatement.executeUpdate();
            ResultSet claves = preparedStatement.getGeneratedKeys();
            while (claves.next()){
                elemento.setId(claves.getInt(1));
            }
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return elemento;
    }

    @Override
    public Paciente actualizar(Paciente elemento) {
        return null;
    }
}
