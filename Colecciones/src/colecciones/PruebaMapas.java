/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

/**
 *
 * @author bryan
 */
import java.util.*;

public class PruebaMapas {

    public static void main(String[] args) {
        HashMap<String, Empleado> personal = new HashMap<String, Empleado>();

        personal.put("145", new Empleado("Alan"));
        personal.put("146", new Empleado("Barbara"));
        personal.put("147", new Empleado("Hayley"));

        System.out.println(personal);

        personal.remove("147");

        System.out.println(personal);

        personal.put("147", new Empleado("Sasha"));

        System.out.println(personal);
        
       // System.out.println(personal.entrySet());
       
        for (Map.Entry<String, Empleado> entrada : personal.entrySet()) {
            String clave = entrada.getKey();
            Empleado valor = entrada.getValue();
            System.out.println("clave="+clave + ", valor=" + valor);
        }
    }
}

class Empleado {

    public Empleado(String nom) {
        nombre = nom;
        sueldo = 2000;
    }

    public String toString() {
        return "[nombre=" + nombre + ", sueldo = " + sueldo + "]";
    }

    private String nombre;
    private double sueldo;
}
