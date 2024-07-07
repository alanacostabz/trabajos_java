/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_propias;

/**
 *
 * @author bryan
 */
public class pareja<T> {
    
    public pareja(){
        primero=null;
    }
    
    public void setPrimero(T nuevoValor){
        
        primero=nuevoValor;
        
    }
    
    public T getPrimero(){
        return primero;
    }
    
    public static void imprimirTrabajador(pareja<? extends Empleado> p){
        
        Empleado primero = p.getPrimero();
        System.out.println(primero);
        
    }
    
    private T primero;
    
}
