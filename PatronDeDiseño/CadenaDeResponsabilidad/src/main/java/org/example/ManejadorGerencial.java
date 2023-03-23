package org.example;

public class ManejadorGerencial extends Manejador{
    public String comprobar(Mail mail) {
        if(mail.getDestino().equals("gerencia@colmena.com") || mail.getTema().equals("gerencia")) {
            return "Enviando a gerencia";
        }
        else {
            return getSiguienteManejador().comprobar(mail);
        }
    }
}
