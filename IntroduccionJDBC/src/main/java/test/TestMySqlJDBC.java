package test;

import java.sql.*;

public class TestMySqlJDBC {

    public static void main(String[] args) {
        // 1. Cadena de conexion para conectarnos a MYSQL
        String url = "jdbc:mysql://localhost:3306/test_java?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

        // 2. Conexion desde java con JDBC
        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root", "admin");

            /*
            crear objeto de tipo statement, para poder ejecutar sentencias
            sobre nuestra tabla de BD
             */
            Statement instruccion = conexion.createStatement();

            // sentencia
            var sql = "SELECT persona_id, nombre, apellido, email, telefono FROM persona";

            // Ejecutar instructtion
            ResultSet resultado = instruccion.executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }
}
