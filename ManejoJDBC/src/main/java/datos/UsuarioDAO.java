package datos;

import domain.Usuario;
import java.sql.*;
import java.util.*;
import static datos.Conexion.*;

public class UsuarioDAO {

    private static final String SQL_SELECT = "SELECT usuario_id, user_name, user_password FROM usuario";

    private static final String SQL_INSERT = "INSERT INTO usuario (user_name, user_password) VALUES (?, ?)";

    private static final String SQL_UPDATE = "UPDATE usuario SET user_name = ?, user_password = ? WHERE usuario_id = ?";

    private static final String SQL_DELETE = "DELETE FROM usuario WHERE usuario_id = ?";

    // seleccionar todos los registros de la tabla usuario
    public List<Usuario> seleccionar() {
        Connection conn = null;
        // preparedStatement es mas eficiente para querys
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {

            conn = getConection();

            stmt = conn.prepareStatement(SQL_SELECT);

            rs = stmt.executeQuery();

            while (rs.next()) {

                int usuarioId = rs.getInt("usuario_id");
                String username = rs.getString("user_name");
                String password = rs.getString("user_password");

                // Crear objeto de tipo usuario
                Usuario user = new Usuario(usuarioId, username, password);

                usuarios.add(user);

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return usuarios;

    }

    // insertar nuevo registro en la tabla de usuarios
    public int insertar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConection();

            // preparar
            stmt = conn.prepareStatement(SQL_INSERT);

            // parametros de la consulta
            stmt.setString(1, usuario.getUser_name());
            stmt.setString(2, usuario.getUser_password());

            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return registros;

    }

    // actualizar registros en la tabla de usuarios
    public int actualizar(Usuario usuario) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConection();

            stmt = conn.prepareStatement(SQL_UPDATE);

            // parametros de la consulta
            stmt.setString(1, usuario.getUser_name());
            stmt.setString(2, usuario.getUser_password());
            stmt.setInt(3, usuario.getUsuarioId());

            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;

    }

    // eliminar registros de la tabla de usuarios
    public int eliminar(Usuario usuario) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {

            conn = Conexion.getConection();

            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, usuario.getUsuarioId());

            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return registros;

    }

}
