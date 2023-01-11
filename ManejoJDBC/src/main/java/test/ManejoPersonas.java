package test;

import datos.PersonaJDBC;
import domain.Persona;
import java.util.List;

public class ManejoPersonas {

    public static void main(String[] args) {
        // Objeto DAO que contiene los metodos para interactuar con la BD
        PersonaJDBC personaDao = new PersonaJDBC();
        
        // Objeto persona con solo el Id para eliminar de la tabla
        Persona personaEliminada = new Persona(5);

        // Eliminar registro de la bd
        personaDao.eliminar(personaEliminada);


        // Crear objeto Persona a insertar en la tabla
//        Persona personaNueva = new Persona("Pedro", "Perez", "correo3@correo.com", "0213150515");
//        
//        Persona personaActualizada = new Persona(6, "pablo", "holman", "correo4@correo.com", "65465165");
//        
//        // Actualizar registro en la bd
//        personaDao.actualizar(personaActualizada);

        // Insertar nuevo objeto Persona
//        personaDao.insertar(personaNueva);

        // seleccionar registro de la tabla
        List<Persona> personas = personaDao.seleccionar();

//        for(Persona persona : personas) {
//            System.out.println(persona);
//        }
        personas.forEach(persona -> {
            System.out.println("persona = " + persona);
        });

    }
}
