package org.example.service.impl;


import org.example.service.IConexionInternet;

public class InternetService implements IConexionInternet {

    public void conectarCon(String url) {
        System.out.println("Conectando con "+url);
    }
}
