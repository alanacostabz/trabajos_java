/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plus;
import java.util.Scanner;

/**
 *
 * @author bryan
 */
public class SumaMain {
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Dame el primer valor: ");
        int valor1 = entrada.nextInt();
        
        System.out.println("Dame el segundo valor: ");
        int valor2 = entrada.nextInt();
        
        Suma valores = new Suma(valor1, valor2);
        
        valores.Imprimir();
    }
    
}
