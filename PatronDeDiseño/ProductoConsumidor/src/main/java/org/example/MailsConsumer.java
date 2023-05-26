package org.example;

import java.util.List;
import java.util.function.Consumer;

public class MailsConsumer extends ProducerConsumerBase{

    ConsumerAction<Mail> action;
    private static volatile int mailsSent;
    private final int totalMails;
    public static List<Mail> allMailsSent;
    public MailsConsumer(String name,MailStorage mailStorage,int totalMails){
        super(name,mailStorage,700);
        this.totalMails =totalMails;
        action = mail -> {
            System.out.println("\n\t\t\t>>" + name + " consume mail de la pila de correos....Contenido del mail->" +
                    mail + "//Enviando mail ..");
            allMailsSent.add(mail);
            mailsSent++;
        };
    }
    @Override
    public void run() {
        while (mailsSent < totalMails){
            mailStorage.sendMail(action);
            simulateEffort();
        }
    }
}
