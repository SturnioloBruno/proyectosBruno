package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AreaCalculatorTest {
    @Test
    @DisplayName("Calcular el área de un círculo con radio 3")
    public void testCalculateCircleAreaWithRadiusThree() {
        double radius = 3;
        double expectedArea = 29.6088132;
        double actualArea = AreaCalculator.calculateCircleArea(radius);
        Assertions.assertEquals(expectedArea, actualArea);
    }

    @Test
    @DisplayName("Calcular el área de un cuadrado con lado 4")
    public void testCalculateSquareAreaWithSideFour() {
        double side = 4;
        double expectedArea = 16;
        double actualArea = AreaCalculator.calculateSquareArea(side);
        Assertions.assertEquals(expectedArea, actualArea);
    }

    @Test
    @DisplayName("Intentar calcular el área de un círculo con radio 0")
    public void testCalculateCircleAreaWithRadiusZero() {
        double radius = 0;
        double expectedArea = 0;
        double actualArea = AreaCalculator.calculateCircleArea(radius);
        Assertions.assertEquals(expectedArea, actualArea);
    }

    @Test
    @DisplayName("Intentar calcular el área de un cuadrado con lado negativo")
    public void testCalculateSquareAreaWithNegativeSide() {
        double side = -4;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AreaCalculator.calculateSquareArea(side);
        });
    }
}