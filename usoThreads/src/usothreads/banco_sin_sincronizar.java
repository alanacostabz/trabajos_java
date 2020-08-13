/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usothreads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bryan
 */
public class banco_sin_sincronizar {

    public static void main(String[] args) {
        Banco b = new Banco();
        for (int i = 0; i < 100; i++) {
            EjecucionTransferencias r = new EjecucionTransferencias(b, i, 2000);
            Thread t = new Thread(r);
            t.start();
        }
    }

}

class Banco {

    public Banco() {

        cuentas = new double[100];

        for (int i = 0; i < cuentas.length; i++) {

            cuentas[i] = 2000;

        }

        // saldoSuficiente=cierreBanco.newCondition();
    }

    public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException {

        //  cierreBanco.lock();
        //try {
        while (cuentas[cuentaOrigen] < cantidad) {

            //saldoSuficiente.await();
            wait();

        }

//if (cuentas[cuentaOrigen] < cantidad) { //evalua que el saldo no es inferior a la cantidad
        //  System.out.println("-------Cantidad insuficiente:" + cuentaOrigen + " -------Saldo: " + cuentas[cuentaOrigen] + " ........Cantidad: " + cantidad);
        // return;
        // } else {
        // System.out.println("---------Cantidad OK--------" + cuentaOrigen);
        //  }
        System.out.println(Thread.currentThread());
        cuentas[cuentaOrigen] -= cantidad; //dinero que sale de la cuenta origen

        System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen, cuentaDestino);

        cuentas[cuentaDestino] += cantidad;

        System.out.printf(" Saldo total: %10.2f%n", getSaldoTotal());
        notifyAll();
        // saldoSuficiente.signalAll();
        //     } finally {
        //cierreBanco.unlock();

        //   }
    }

    public double getSaldoTotal() {

        double sumaCuentas = 0;
        for (double a : cuentas) {
            sumaCuentas += a;

        }
        return sumaCuentas;

    }
    private final double[] cuentas;
    //private Lock cierreBanco = new ReentrantLock();
    //private Condition saldoSuficiente;
}

class EjecucionTransferencias implements Runnable {

    public EjecucionTransferencias(Banco b, int de, double max) {

        banco = b;
        deLaCuenta = de;
        cantidadMax = max;

    }

    public void run() {

        while (true) {
            try {
                int paraLaCuenta = (int) (100 * Math.random());
                double cantidad = cantidadMax * Math.random();
                banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException ex) {
                Logger.getLogger(EjecucionTransferencias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private Banco banco;
    private int deLaCuenta;
    private double cantidadMax;

}
