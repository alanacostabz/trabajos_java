/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.util.Scanner;

/**
 *
 * @author bryan
 */
public abstract class ClasePadre_Abstracta {
    protected int transacciones, retiro, deposito;
    private static int saldo;
    Scanner sc = new Scanner(System.in);
    
    public void Operaciones() {
        int bandera = 0;
        int seleccion = 0;
        do {
        do {
            System.out.println("Por favor seleccione una opción:");
            System.out.println("1. Consulta de saldo\n2. Retiro de efectivo\n3. Deposito de efectivo\n4. Salir");
            seleccion = sc.nextInt();
            
            if (seleccion>=1 && seleccion <=4) {
                bandera = 0;
            } else {
                System.out.println("----------------------------------------------");
                System.out.println("Opción no disponible, vuelva itentar por favor");
                System.out.println("----------------------------------------------");
            }
        } while (bandera != 0);
            if (seleccion == 1) {
                ClasePadre_Abstracta mensajero = new ClaseHija_Consulta();
                mensajero.Transacciones();
            } else if(seleccion == 2) {
                ClasePadre_Abstracta mensajero = new ClaseHija_Retiro();
                mensajero.Transacciones(); 
            } else if (seleccion == 3) {
                ClasePadre_Abstracta mensajero = new ClaseHija_Deposito();
                mensajero.Transacciones();
            } else if(seleccion == 4) {
                    System.out.println("-----------------------");
                    System.out.println("Gracias, vuelva pronto");
                    System.out.println("-----------------------");
                    bandera = 2;
            }
        } while (bandera != 2);
    }
    
    // Método para solicitar cantidad de retiro
    public void Retiro(){
        retiro = sc.nextInt();
    }
    
    // Método para solicitar deposito
    public void Deposito(){
        deposito = sc.nextInt();
    }
    
    // Método abastracto
    public abstract void Transacciones();
    
    // Métodos getter y setter
    public int getSaldo() {
        return saldo;
    }
    
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
