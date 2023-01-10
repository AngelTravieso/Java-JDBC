package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.util.List;

public class TestManejoUsuarios {

    public static void main(String[] args) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        
        // objeto usuario a insertar en la tabla
        Usuario usuarioNuevo = new Usuario("gustavo", "65478");
        
        // insertar usuario en la tabla usuario
//        usuarioDao.insertar(usuarioNuevo);

        // actualizar registro en la tabla usuario
        Usuario usuarioActualizado = new Usuario(2, "jose", "6565165");
        
//        usuarioDao.actualizar(usuarioActualizado);

        // eliminar usuario
        Usuario usuarioEliminado = new Usuario(2);
        
        usuarioDao.eliminar(usuarioEliminado);
        
        
        List<Usuario> usuarios = usuarioDao.seleccionar();
        
        usuarios.forEach(usuario -> {
            System.out.println("usuario = " + usuario);
        });
        
    }
}
