/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea_1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author bryan
 */
public class Tarea_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //String candidate = "YcasacasacasacasacasacasacasacasacasacasaX"; //entre Y y X existen 40 caracteres -- NO MATCH
        //String candidate = "YcasacasacasacasacasacasacasacasacasacasaaX";  //entre Y y X existen 41 caracteres -- MATCH
        // String candidate = "casacasacasacasacasacasacasacasacasacasaaX";  //No tiene Y antes de X -- MATCH

        String candidate = "Y less than 40 before X";
        String regex = "(?<!Y.{0,40})X";

        //X, mientras que no preceda de una Y con un rango de cualquier caracter de 0 a 40
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(candidate);
        System.out.println(matcher.find());
        candidate = "Y less ddddddddddddddddddddddddddddddddddddd than 40 before X";
        matcher.reset(candidate);
        System.out.println(matcher.find());

        String tmp = null;
        while (matcher.find()) {
            tmp = matcher.group();
            System.out.println("MATCH: " + tmp);
        }
    }

}
