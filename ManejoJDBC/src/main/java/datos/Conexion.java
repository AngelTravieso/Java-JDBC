package datos;

import java.sql.*;

// Clase de conexion
public class Conexion {

    // url (puerto y parametros)
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test_java?&useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    // usuario
    private static final String JDBC_USER = "root";

    // password
    private static final String JDBC_PASSWORD = "";

    // obtener conexion mysl
    public static Connection getConection() throws SQLException {

        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    // sobrecargar metodos
    // cerrar objetos de conexion
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(PreparedStatement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(Connection conn) throws SQLException {
        conn.close();
    }

}
