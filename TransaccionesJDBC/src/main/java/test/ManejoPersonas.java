package test;

import datos.*;
import domain.Persona;
import java.sql.*;

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
            PersonaJDBC personaJdbc = new PersonaJDBC(conexion);

            // ejecutar sentencias dentro de la transaccion
            Persona cambioPersona = new Persona(9);
            cambioPersona.setNombre("angel actualizado");
            cambioPersona.setApellido("travieso");
            cambioPersona.setEmail("correo5@correo.com");
            cambioPersona.setTelefono("651618189");

            // update
            personaJdbc.actualizar(cambioPersona);

            Persona nuevaPersona = new Persona("gustavo", "castro", "correo6@corre.com", "9911321");

            // insertar
            personaJdbc.insertar(nuevaPersona);

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
