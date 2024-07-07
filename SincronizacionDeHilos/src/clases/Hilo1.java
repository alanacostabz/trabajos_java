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
public class Hilo1 extends Thread {
    @Override
    public void run(){
        for (int i = 0; i <= 5; i++) {
            System.out.print(i + ": G");
            
            try {
                Hilo1.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println("Erroe en la clase Hilo1 " + e);
            }
        }
    }
}
