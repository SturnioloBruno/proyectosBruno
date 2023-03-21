package org.example;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private List<Persona> listaPersonas;

    public Grupo() {
        this.listaPersonas = new ArrayList<Persona>();
    }

    public void agregarPersona(Persona p) {
        // condicion
        if ( p.getEdad() > 18 && p.getNombre().length() >= 5)
            listaPersonas.add(p);
        else {
            System.err.println("no se puede agregar a " + p);
        }
    }

    public int getPersonasEnElGrupo() {
        return listaPersonas.size();
    }
}
