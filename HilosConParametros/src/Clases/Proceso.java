/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author bryan
 */
public class Proceso extends Thread {
    int numEntero;
    public Proceso(String nombreHilo) {
        super(nombreHilo);
    }
    
    @Override
    public void run(){
        for (int i = 0; i <= numEntero; i++) {
            System.out.println(i + this.getName());
        }
        System.out.println("");
    }
    
    public void valorDeLaCondicion(int valor) {
        this.numEntero = valor;
    }
}
