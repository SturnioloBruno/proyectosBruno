package org.example;

import com.github.javafaker.Faker;

import java.util.concurrent.atomic.AtomicInteger;

public class MailsProducer extends ProducerConsumerBase{

    private final Faker faker = new Faker();
    ProducerAction<Mail> action;
    public static AtomicInteger numberOfMailsToSend;

    public MailsProducer(String name, MailStorage mailStorage){
        super(name,mailStorage,100);
        action = () -> {
            var mail = createMail();
            System.out.println("\n<<" + name + " coloca en la pila de correos el iguiente mail ->" +
                    mail + ">>");
            return mail;
        };
    }

    private Mail createMail() {
        return new Mail();
    }
    @Override
    public void run() {

    }
}
