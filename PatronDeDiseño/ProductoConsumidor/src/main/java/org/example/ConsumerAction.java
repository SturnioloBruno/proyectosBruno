package org.example;

@FunctionalInterface
public interface ConsumerAction<Consumable> {
    void consume(Consumable obj);
}
