/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

import java.util.*;

/**
 *
 * @author bryan
 */
public class PruebaListaEnlazada {
    
    public static void main(String[] args) {
        LinkedList<String> equipos = new LinkedList<String>();
        
        equipos.add("América");
        equipos.add("Juventus");
        equipos.add("Real Madrid");
        equipos.add("Manchester United");
        
        LinkedList<String> ligas = new LinkedList<String>();
        
        ligas.add("Liga MX");
        ligas.add("Serie A");
        ligas.add("La Liga");
        ligas.add("Premier League");

        /*System.out.println(equipos);
        System.out.println(ligas);*/
        ListIterator<String> iterA = equipos.listIterator();
        ListIterator<String> iterB = ligas.listIterator();
        
        while (iterB.hasNext()) {
            if (iterA.hasNext()) {
                iterA.next();
                
            }
            iterA.add(iterB.next());
            
        }
        System.out.println(equipos);
        
        iterB = ligas.listIterator();
        
        while (iterB.hasNext()) {
            iterB.next();
            if (iterB.hasNext()) {
                iterB.next();
                iterB.remove();
            }
        }
        System.out.println(ligas);
        
        equipos.removeAll(ligas);
        
        System.out.println(equipos);
    }
    
}
