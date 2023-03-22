package org.example;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidadorTest {
    @Test
    public void testEsPar(){
        //Dado
        int numero = 4;
        //Cuando
        int resultado = Validador.esPar(numero);
        //Entonces
        Assert.assertTrue(resultado == 1);
    }
}