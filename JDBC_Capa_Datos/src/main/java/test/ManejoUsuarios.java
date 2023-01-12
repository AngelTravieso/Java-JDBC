package test;

import datos.*;
import domain.UsuarioDto;
import java.sql.*;
import java.util.List;

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

            UsuarioDao usuarioDao = new UsuarioDaoJDBC(conn);

            List<UsuarioDto> usuarios = usuarioDao.select();

            usuarios.forEach(usuario -> {
                System.out.println("usuario DTO = " + usuario);
            });

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
