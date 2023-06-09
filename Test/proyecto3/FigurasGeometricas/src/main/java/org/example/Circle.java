package org.example;

public class Circle implements FiguraGeometrica{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(radius,2);
    }
}
