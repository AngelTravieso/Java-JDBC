package datos;

import domain.UsuarioDto;
import java.sql.SQLException;
import java.util.List;

public interface UsuarioDao {

    public List<UsuarioDto> select() throws SQLException;

    public int insert(UsuarioDto usuario) throws SQLException;

    public int update(UsuarioDto usuario) throws SQLException;

    public int delete(UsuarioDto usuario) throws SQLException;

}
