/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aleatorios;

import javax.swing.JOptionPane;

/**
 *
 * @author bryan
 */
public class Aleatorios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int elementos=Integer.parseInt(JOptionPane.showInputDialog("Introduce elementos de la matriz"));
        
        int numAleatorio[]=new int[elementos];
        
        for (int i = 0; i<numAleatorio.length; i++) {
            
            numAleatorio[i] =(int) (Math.random() * 100);
            
        }
        for (int elem: numAleatorio) {
            System.out.println(elem);
            
        }
    }
    
}
