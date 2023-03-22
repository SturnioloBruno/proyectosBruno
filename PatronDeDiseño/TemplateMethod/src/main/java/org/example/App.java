package org.example;

import org.example.service.Cocinero;
import org.example.service.impl.CocineroNoVeggie;
import org.example.service.impl.CocineroVeggie;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Cocinero cocineroVeggie = new CocineroVeggie();
        Cocinero cocineroNoVeggie = new CocineroNoVeggie();

        cocineroVeggie.hacerPizza();
        cocineroNoVeggie.hacerPizza();
    }
}
