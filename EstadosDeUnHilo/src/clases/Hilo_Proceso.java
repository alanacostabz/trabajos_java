/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author bryan
 */
public class Hilo_Proceso extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println(i  + " " + getName());
            try {
                Hilo_Proceso.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error dentro de la clase");
            }
        }
    }
}
