/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import javax.swing.JOptionPane;

public class Pila {
    private Nodo ultimoValorIngresado;
    int tamano = 0;
    String lista = "";
    
    public Pila(){
        ultimoValorIngresado = null;
        tamano = 0;
    }
    
    // Método para saber cuando la pila está vacía
    public boolean PilaVacia(){
        return ultimoValorIngresado == null;
    }
    
    // Método para insertar un nodo en la pila
    public void InsertarNodo(int nodo){
        Nodo nuevoNodo = new Nodo(nodo);
        nuevoNodo.siguiente = ultimoValorIngresado;
        ultimoValorIngresado = nuevoNodo;
        tamano++;
    }
    
    // Método para eliminar un nodo de la pila
    public int EliminarNodo(){
        int aux = ultimoValorIngresado.informacion;
        ultimoValorIngresado = ultimoValorIngresado.siguiente;
        tamano--;
        return aux;
    }
    
    // Método para conocer ultimo valor ingresado
    public int MostrarUltimoValorIngresado(){
        return ultimoValorIngresado.informacion;
    }
    
    // Método para conocer el tamaño de la pila
    public int TamanoFila(){
        return tamano;
    }
    
    // Método para vaciar la pila
    public void VaciarPila() {
        while (!PilaVacia()) {
            EliminarNodo();
        }
    }
    
    // Método para mostrar el contenido de la pila
    public void MostrarValores(){
        Nodo recorrido = ultimoValorIngresado;
        
        while (recorrido != null) {
            lista += recorrido.informacion + "\n";
            recorrido = recorrido.siguiente;
        }
        
        JOptionPane.showMessageDialog(null, lista);
        lista = "";
    }
}
