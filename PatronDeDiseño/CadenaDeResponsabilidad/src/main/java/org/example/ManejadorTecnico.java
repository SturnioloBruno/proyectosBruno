package org.example;

public class ManejadorTecnico extends Manejador{
    public String comprobar(Mail mail) {
        if(mail.getDestino().equals("tecnico@colmena.com") || mail.getTema().equals("tecnico")) {
            return "Enviando a tecnico";
        }
        else {
            return getSiguienteManejador().comprobar(mail);
        }
    }
}
