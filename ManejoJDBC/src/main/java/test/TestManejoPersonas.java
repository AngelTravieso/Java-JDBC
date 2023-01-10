package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.List;

public class TestManejoPersonas {

    public static void main(String[] args) {
        // Objeto DAO que contiene los metodos para interactuar con la BD
        PersonaDAO personaDao = new PersonaDAO();

        // Insertar nuevo objeto Persona
        Persona personaNueva = new Persona("Pedro", "Perez", "correo3@correo.com", "0213150515");

        personaDao.insertar(personaNueva);

        List<Persona> personas = personaDao.seleccionar();

//        for(Persona persona : personas) {
//            System.out.println(persona);
//        }
        personas.forEach(persona -> {
            System.out.println("persona = " + persona);
        });

    }
}
