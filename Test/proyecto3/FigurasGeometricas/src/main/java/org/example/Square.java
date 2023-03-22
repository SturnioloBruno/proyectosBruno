package org.example;

public class Square implements FiguraGeometrica {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double calcularArea() {
        return side * side;
    }
}
