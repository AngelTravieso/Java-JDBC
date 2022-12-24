package test;

import java.sql.*;

public class TestMySqlJDBC {

    public static void main(String[] args) {
        // 1. Cadena de conexion para conectarnos a MYSQL
        String url = "jdbc:mysql://localhost:3306/test?&useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

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

            /*
            como puede devolver mas de un registro se debe iterar el
            resultado usando un ciclo while
             */
            // si hay elementos para iterar
            while (resultado.next()) {
                // recuperar columna
                System.out.print("Id Persona: " + resultado.getInt("persona_id") + ",");
                System.out.print(" Nombre: " + resultado.getString("nombre") + " ,");
                System.out.print(" Apellido: " + resultado.getString("apellido") + ",");
                
                System.out.print(" Email: " + resultado.getString("email") + ",");
                
                System.out.print(" Telefono: " + resultado.getString("telefono") + ",");
                
                System.out.println("");

            }
            
            // cerrar objetos de conexion
            resultado.close();
            instruccion.close();
            conexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }
}
