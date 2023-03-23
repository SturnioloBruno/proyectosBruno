package org.example;

public class CompruebaMail {
    private Manejador inicial;

    public CompruebaMail() {

        // Al pasarlos por constructor luego no tengo que verificar los null

        inicial = new ManejadorComercial();
        Manejador tecnico = new ManejadorTecnico();
        Manejador gerencial = new ManejadorGerencial();
        Manejador spam = new ManejadorSpam();

        inicial.setSiguienteManejador(gerencial);
        gerencial.setSiguienteManejador(tecnico);
        tecnico.setSiguienteManejador(spam);
    }

    public String comprobar(Mail mail) {
        return inicial.comprobar(mail);
    }
}
