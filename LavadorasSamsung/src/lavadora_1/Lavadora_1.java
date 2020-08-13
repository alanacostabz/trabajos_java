/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lavadora_1;
import Libreria.LLFunciones;
import java.util.Scanner;

/**
 *
 * @author bryan
 */
public class Lavadora_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("La ropa es blanca o de color");
        System.out.println("1) Blanca ------ 2) Color");
        int tipoDeRopa = sc.nextInt();
        
        System.out.println("Ingrese kilos de ropa");
        int kilos = sc.nextInt();
        
        LLFunciones mensajeros = new LLFunciones(kilos, tipoDeRopa);
        
        mensajeros.setTipoDeRopa(2);
        System.out.println("El tipo de ropa es: " + mensajeros.getTipoDeRopa());
        mensajeros.CicloFinalizado();
        
        
    }
    
}
