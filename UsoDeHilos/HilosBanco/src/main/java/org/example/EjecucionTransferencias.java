package org.example;

public class EjecucionTransferencias implements Runnable{
    private Banco banco;
    private int deLaCuenta;
    private double cantidadMax;

    public EjecucionTransferencias(Banco banco, int deLaCuenta, double cantidadMax) {
        this.banco = banco;
        this.deLaCuenta = deLaCuenta;
        this.cantidadMax = cantidadMax;
    }

    public void run() {

        try {


            while (true) {
                int paraLaCuenta = (int) (100 * Math.random());
                double cantidad = cantidadMax * Math.random();
                banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);
                Thread.sleep((int) (Math.random() * 10));
            }
        }catch (InterruptedException e) {

        }
    }
}
