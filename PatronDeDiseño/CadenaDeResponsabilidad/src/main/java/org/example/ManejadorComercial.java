package org.example;

public class ManejadorComercial extends Manejador{
    public String comprobar(Mail mail) {
        if(mail.getDestino().equals("comercial@colmena.com") || mail.getTema().equals("comercial")) {
            return "Enviando a comercial";
        }
        else {
            return getSiguienteManejador().comprobar(mail);
        }
    }
}
