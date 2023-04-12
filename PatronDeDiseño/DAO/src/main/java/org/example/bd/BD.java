package org.example.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {
    private final static String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS medicamentos;"
        + " CREATE TABLE medicamentos (ID INT AUTO_INCREMENT PRIMARY KEY,"
        + " NOMBRE varchar(100),"
        + " LABORATORIO varchar(100),"
        + " CANTIDAD INT,"
        + " PRECIO DOUBLE)";
    public static void crearBD() throws Exception{
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:h2:~/DAO","sa","");
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}
