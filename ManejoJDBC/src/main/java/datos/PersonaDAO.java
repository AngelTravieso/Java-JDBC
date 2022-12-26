package datos;

import domain.Persona;
import java.sql.*;
import java.util.*;
import static datos.Conexion.*;

public class PersonaDAO {

    private static final String SQL_SELECT = "SELECT persona_id, nombre, apellido, email, telefono FROM persona";

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

                return personas;

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

}
