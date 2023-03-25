package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class RegistroTest {
    @Test
    public void vacunarPersonaCorrecta() {
        //Dado
        Persona persona = new Persona("Juan","Perez","36046044","Pfizer",new Date(2023-1900,3-1,24));
        Registro registro = new RegistroVacunaProxy();
        String respEsperada = "Se ha registrado el DNI " + persona.getDNI() +
                " como persona vacunada con " + persona.getNombreVacuna();
        //Cuando
        String respuesta = registro.vacunar(persona);
        //Entonces
        Assertions.assertEquals(respEsperada,respuesta);
    }

}