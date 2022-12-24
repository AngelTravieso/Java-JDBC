package datos;

import domain.Persona;
import java.sql.*;
import java.util.*;

public class PersonaDAO {
    private static final String SQL_SELECT = "SELECT persona_id, nombre, apellido, email, telefono FROM persona";
    
    public List<Persona> seleccionar() {
        Connection conn = null;
        // preparedStatement es mas eficiente para querys
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();
    }
    
}
