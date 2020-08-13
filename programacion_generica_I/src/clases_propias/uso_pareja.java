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
public class uso_pareja {
    
    public static void main(String[] args) {
        pareja<String> una = new pareja<String>();
        una.setPrimero("Alan");
        System.out.println(una.getPrimero());
        Persona pers1=new Persona("Maritza");
        pareja<Persona> otra = new pareja<Persona>();
        otra.setPrimero(pers1);
        System.out.println(otra.getPrimero());
    }
    
}

class Persona{
    public Persona(String nombre){
        this.nombre=nombre;
    }
    
    public String toString(){
        return nombre;
    }
    
    private String nombre;
}
