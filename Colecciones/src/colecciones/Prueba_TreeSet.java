/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

import java.util.Comparator;
import java.util.TreeSet;

/**
 *
 * @author bryan
 */
public class Prueba_TreeSet {

    public static void main(String[] args) {
        /* TreeSet<String> ordernarPersonas = new TreeSet<String>();
        
        
        ordernarPersonas.add("Barbara");
        ordernarPersonas.add("Hayley");
         ordernarPersonas.add("Alan");
        
        
        for (String ordernarPersona : ordernarPersonas) {
            System.out.println(ordernarPersona);
        }*/

        Articulo primero = new Articulo(1, "Primer artículo");
        Articulo segundo = new Articulo(2, "Segundo artículo");
        Articulo tercero = new Articulo(3, "Este es el tercer artículo");

        TreeSet<Articulo> ordernarArticulo = new TreeSet<Articulo>();
        ordernarArticulo.add(tercero);
        ordernarArticulo.add(segundo);
        ordernarArticulo.add(primero);

        for (Articulo articulo : ordernarArticulo) {
            System.out.println(articulo.getDescripcion());
        }
        /* Articulo comparadorArt = new Articulo();
        TreeSet <Articulo> ordenaArticulos2 = new TreeSet<Articulo>(comparadorArt);
      
         */
        // ComparadorArticulos comparaArt = new ComparadorArticulos();
        TreeSet<Articulo> ordenaArticulos2 = new TreeSet<Articulo>(new Comparator<Articulo>() {
            @Override
            public int compare(Articulo o1, Articulo o2) {
                String des1 = o1.getDescripcion();
                String des2 = o2.getDescripcion();
                return des1.compareTo(des2);
            }
        });
        ordenaArticulos2.add(primero);
        ordenaArticulos2.add(segundo);
        ordenaArticulos2.add(tercero);

        for (Articulo articulo : ordenaArticulos2) {
            System.out.println(articulo.getDescripcion());
        }
    }

}

class Articulo implements Comparable<Articulo> {

    public Articulo(int num, String desc) {
        numArticulo = num;
        descripcion = desc;
    }

    @Override
    public int compareTo(Articulo o) {
        return numArticulo - o.numArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    private int numArticulo;
    private String descripcion;

}
