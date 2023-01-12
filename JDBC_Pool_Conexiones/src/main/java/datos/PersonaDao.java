package datos;

import domain.PersonaDto;
import java.sql.SQLException;
import java.util.List;

public interface PersonaDao {

    public List<PersonaDto> select() throws SQLException;

    public int insert(PersonaDto persona) throws SQLException;

    public int update(PersonaDto persona) throws SQLException;

    public int delete(PersonaDto persona) throws SQLException;

}
