package org.example.service.impl;

import org.example.service.Cocinero;

public class CocineroVeggie extends Cocinero {
    protected void prepararIngredientes() {
        System.out.println("Preparando tomate y diferentes quesos");
    }

    protected void agregarIngredientes() {
        System.out.println("Agregando quesos y tomate");
    }
}
