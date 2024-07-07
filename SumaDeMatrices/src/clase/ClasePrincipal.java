/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase;

/**
 *
 * @author bryan
 */
public class ClasePrincipal {
    public static void main(String[] args) {
        int matriz1[][] = new int [3][3];
        int matriz2[][] = new int [3][3];
        int matrizResultante[][] = new int [3][3];
        
        // Llenado de la primer matriz
        for (int i = 0; i < matriz1.length ; i++) {
            for (int j = 0; j < matriz1.length; j++) {
                matriz1[i][j] = (int) Math.random() * 5;
             }
        }
        
        // Llenado de la segunda matriz
        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2.length; j++) {
                matriz2[i][j] = (int) Math.random() * 5;
            }
        }
        
        // Suma o resta de matrices
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz2.length; j++) {
                // Suma 
                matrizResultante[i][j] = matriz1[i][j] + matriz2[i][j]; 
            }
        }
        
        // Imprimiendo las matrices
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1.length; j++) {
                System.out.print("[ " + matriz1[i][j] + " ]");
            }
            System.out.println("\t");
        
        for (int j = 0; j < matriz2.length; i++) {
            System.out.println("[ " + matriz2[i][j] + " ]");
        }
        }
    }
}
