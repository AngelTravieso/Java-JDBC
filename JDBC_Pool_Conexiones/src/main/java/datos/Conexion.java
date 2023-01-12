package datos;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

// Clase de conexion
public class Conexion {

    // url (puerto y parametros)
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test_java?&useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    // usuario
    private static final String JDBC_USER = "root";

    // password
    private static final String JDBC_PASSWORD = "";

    // Objeto para inicializar pool de conexiones
    private static BasicDataSource dataSource;

    public static DataSource getDataSource() {

        if (dataSource == null) {
            BasicDataSource ds = new BasicDataSource();

            // Proporcionar valores para configurar pool de conexiones
            ds.setUrl(JDBC_URL);
            ds.setUsername(JDBC_USER);
            ds.setPassword(JDBC_PASSWORD);

            // definir el tamaño inicial del pool de conexiones
            ds.setInitialSize(5);
        }

        return dataSource;
    }

    // obtener conexion mysl (con pool de conexiones)
    public static Connection getConection() throws SQLException {
        return getDataSource().getConnection();
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
