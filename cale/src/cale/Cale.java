/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cale;

/**
 *
 * @author bryan
 */
public class Cale {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = "yo-dude: like, ... []{}14this is a string";
        s = s.replaceAll("[^a-zA-Z]", "");
        System.out.println(s);
    }

}
