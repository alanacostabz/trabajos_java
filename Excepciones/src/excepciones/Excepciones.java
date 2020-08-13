/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

import javax.swing.JOptionPane;

/**
 *
 * @author bryan
 */
public class Excepciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] miMatriz = new int[5];
        
        miMatriz[0]=5;
        miMatriz[1]=38;
        miMatriz[2]=-15;
        miMatriz[3]=92;
        miMatriz[4]=71;
        
        for (int i = 0; i < 5; i++) {
            
            System.out.println("Posición: " + i +": "+ miMatriz[i]);
            
        }
        
        String nombre=JOptionPane.showInputDialog("Introduce tu nombre");
        
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Intorduce tu edad"));
        
        System.out.println("Hola " + nombre + " tienes " + edad + " años." + "El programa terminó su ejecución.");
   
    }
    
}
