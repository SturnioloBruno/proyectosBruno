package models;

public class Minotauro extends Enemy{
    public void fight() {
        attack((int endx, int endy) -> {
            int diffX = endx - this.getPosX();
            int diffY = endy - this.getPosY();
            return  diffX * diffX + diffY * diffY;
        });
    }

    public void attack(CalculateDistance calculateDistance) {
        int distancia = calculateDistance.calculate(this.getPosX() + 10, this.getPosY());
        if (distancia > 20) {
            System.out.println("Especial attack");
        }
    }
}
