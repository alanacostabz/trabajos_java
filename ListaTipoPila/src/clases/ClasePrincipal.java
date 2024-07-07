/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import javax.swing.JOptionPane;

/**
 *
 * @author bryan
 */
public class ClasePrincipal {
    public static void main(String[] args) {
        int opcion = 0, nodo = 0;
        Pila pila = new Pila();
        
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, 
                        "Menu de opciones\n\n" + 
                        "1. Insertar un nodo\n" + 
                        "2. Eliminar un nodo\n" +
                        "3. Mostrar si la pila esta vacía\n" +
                        "4. Ultimo valor ingresado a la pila\n" + 
                        "5. Cuantos nodos tiene la pila?\n" + 
                        "6. Vaciar pila\n" + 
                        "7. Mostrar contenido de la pila\n" + 
                        "8. Salir\n"));
            } catch(NumberFormatException e) {
                
            }
            
        } while (opcion != 8);
        
        
    }
}
