/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varias_excepciones;

import javax.swing.JOptionPane;

/**
 *
 * @author bryan
 */
public class Varias_excepciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try{
        division();
        }catch(ArithmeticException e){
            System.out.println("Estas dividiendo por 0");
        } catch(NumberFormatException e){
            System.out.println("No has introducido un numero entero");
           // System.out.println(e.getMessage());
            System.out.println("Se ha generado un error de tipo: " + e.getClass().getName());
        }
    }
    
    static void division(){
        int n1=Integer.parseInt(JOptionPane.showInputDialog("Introduce el dividendo:"));
        int n2=Integer.parseInt(JOptionPane.showInputDialog("Introduce el divisor:"));
        
        System.out.println("El resultado es: " + n1/n2);
    }
}
