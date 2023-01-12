package test;

import datos.*;
import domain.Usuario;
import java.sql.*;

public class ManejoUsuarios {

    public static void main(String[] args) {

        Connection conn = null;

        try {
            conn = Conexion.getConection();

            // Si el autocommit esta activado
            if (conn.getAutoCommit()) {
                // desactivarlo para evitar commits automaticos
                conn.setAutoCommit(false);

            }

            UsuarioJDBC usuarioJdbc = new UsuarioJDBC(conn);

            // actualizar registro en la tabla de usuario
            Usuario usuarioActualizado = new Usuario(3);
            usuarioActualizado.setUser_name("gustavo actualizado");
            usuarioActualizado.setUser_password("1234 actualizada");

            usuarioJdbc.actualizar(usuarioActualizado);

            // insertar nuevo registro en la tabla de usuario
            Usuario nuevoUsuario = new Usuario("pedro", "clave secreta");

            usuarioJdbc.insertar(nuevoUsuario);

            // si todo sale bien hacer commit de la transaccion
            conn.commit();

            System.out.println("Se ha hecho commit de la transaccion");

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

            System.out.println("Entramos al rollback");

            try {
                // si la transaccion sale mal hacer rollback
                conn.rollback();

                System.out.println("Se ha hecho rollback a la transaccion");
            } catch (SQLException ex1) {
                ex.printStackTrace(System.out);

            }

        }

    }
}
