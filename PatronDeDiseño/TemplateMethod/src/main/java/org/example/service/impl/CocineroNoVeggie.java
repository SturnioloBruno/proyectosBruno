package org.example.service.impl;

import org.example.service.Cocinero;

public class CocineroNoVeggie extends Cocinero {
    protected void prepararIngredientes() {
        System.out.println("Preparando queso y fetas de jamon,");
    }

    protected void agregarIngredientes() {
        System.out.println("Agregando los ingredientes");
    }
}
