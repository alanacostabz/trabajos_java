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
public class UsoLibro {

    public static void main(String[] args) {
        Libro l1 = new Libro("P en java", "Alan Acosta", 25);
        Libro l2 = new Libro("P en java II", "Alan Acosta", 15);
        
        //l1=l2;

        if (l1.equals(l2)) {
            System.out.println("Es el mismo libro");
            System.out.println(l1.hashCode());
            System.out.println(l2.hashCode());
        } else {
            System.out.println("Son libros diferentes");
            System.out.println(l1.hashCode());
            System.out.println(l2.hashCode());
        }
    }
}
