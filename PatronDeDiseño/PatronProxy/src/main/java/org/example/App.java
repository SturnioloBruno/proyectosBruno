package org.example;

import org.example.service.IConexionInternet;
import org.example.service.impl.InternetService;
import org.example.service.impl.ProxyInternet;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        List<String> sitiosBloqueados = Arrays.asList("www.youtube.com","www.facebook.com");
        IConexionInternet proxy = new ProxyInternet(sitiosBloqueados,new InternetService());

        proxy.conectarCon("www.google.com");
        proxy.conectarCon("www.youtube.com");
    }
}
