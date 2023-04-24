package org.example;

@FunctionalInterface
public interface ProducerAction<Producible> {
    Producible produce();
}
