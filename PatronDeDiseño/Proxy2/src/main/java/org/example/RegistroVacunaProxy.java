package org.example;

import java.util.Date;

public class RegistroVacunaProxy implements Registro{
    private RegistroVacuna registroVacuna;
    public String vacunar(Persona persona) {
        Date hoy = new Date();
        String mensaje = "Vuelva cuando sea su turno. :D";
        if (hoy.after(persona.getFechaAsignada())) {
            // tiene que pasar al otro sector de vacunacion
            registroVacuna = new RegistroVacuna();
            mensaje = registroVacuna.vacunar(persona);
        }
        //no me importa que los String sean inmutables, no es el proposito del ej.
        return mensaje;
    }
}
