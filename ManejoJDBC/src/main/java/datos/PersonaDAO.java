package datos;

import domain.Persona;
import java.sql.*;
import java.util.*;
import static datos.Conexion.*;

public class PersonaDAO {

    private static final String SQL_SELECT = "SELECT persona_id, nombre, apellido, email, telefono FROM persona";

    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES (?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE persona_id = ?";

    private static final String SQL_DELETE = "DELETE FROM persona WHERE persona_id = ?";

    public List<Persona> seleccionar() {
        Connection conn = null;
        // preparedStatement es mas eficiente para querys
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        try {
            // conectarnos a la base de datos
            conn = getConection();

            // SQL a ejecutar
            stmt = conn.prepareStatement(SQL_SELECT);

            // Ejecutar query
            rs = stmt.executeQuery();

            // iterar registros para crear objetos tipo Persona
            while (rs.next()) {
                int personaId = rs.getInt("persona_id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");

                // crear objeto persona
                persona = new Persona(personaId, nombre, apellido, email, telefono);

                // agregar objeto persona a la lista (List<Persona>)
                personas.add(persona);

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                // cerrar objetos de conexion
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            return personas;

        }

    }

    // insertar objeto Persona en la tabla
    public int insertar(Persona persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_INSERT);

            /**
             * 1er param: parametro correspondiente al query del insert 2do 2do
             * param: valor del parametro
             */
            // se llama setString porque es un campo String/Text/Varchar de la tabla, sino se llama su equivalente
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());

            // ejecutar sentencia sql
            registros = stmt.executeUpdate(); // esto ejecuta un insert, update o delete

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                // cerrar objetos de conexion
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return registros;

    }

    // actualizar registro de la tabla
    public int actualizar(Persona persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConection();

            stmt = conn.prepareStatement(SQL_UPDATE);

            // parametros
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setInt(5, persona.getPersonaId());

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

    // eliminar registro de la tabla
    public int eliminar(int personaId) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConection();

            stmt = conn.prepareStatement(SQL_DELETE);

            // parametros del query
            stmt.setInt(1, personaId);

            // ejecutar query
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
