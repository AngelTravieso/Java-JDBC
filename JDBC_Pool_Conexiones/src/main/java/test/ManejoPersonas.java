package test;

import datos.*;
import domain.PersonaDto;
import java.sql.*;
import java.util.List;

public class ManejoPersonas {

    public static void main(String[] args) {

        Connection conexion = null;

        try {

            conexion = Conexion.getConection();

            // chequear si la conexion esta en modo autoCommit (default true)
            if (conexion.getAutoCommit()) {
                /**
                 * esto es porque no necesitamos que la conexion haga autocommit
                 * de manera automatica, ya que lo manejaremos de forma manual
                 */
                conexion.setAutoCommit(false);
            }

            // conexion transaccional
            PersonaDao personaDao = new PersonaDaoJDBC(conexion);

            List<PersonaDto> personas = personaDao.select();

            personas.forEach(persona -> {
                System.out.println("persona DTO = " + persona);
            });

            // aqui se guardan los cambios en la BD (manual)
            conexion.commit();

            System.out.println("Se ha hecho commit de la transaccion");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");

            try {
                /**
                 * si algo sale mal con la transaccion los cambios se echan para
                 * atras con un rollback
                 */

                conexion.rollback();
            } catch (SQLException ex1) {
                ex.printStackTrace(System.out);
            }

        }

    }
}
