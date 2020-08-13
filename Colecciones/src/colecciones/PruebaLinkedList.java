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
public class PruebaLinkedList {
    public static void main(String[] args) {
        LinkedList<String> personas = new LinkedList<String>();
        personas.add("Barbara");
        personas.add("Alan");
        personas.add("Hayley");
        personas.add("Fernanda");
        
        
        System.out.println(personas.size());
        
        ListIterator<String> it = personas.listIterator();
        
        it.next();
        it.add("Maritza");
        
        for (String persona : personas) {
            System.out.println(persona);
        }
              
    }
}
