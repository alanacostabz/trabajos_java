/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regex_extraccionpractica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author bryan
 */
public class Regex_extraccionPractica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        File file = new File("F:\\testing\\RegEx_extraccionCURP\\datos.txt"); // cambiar si se lee desde otro fichero
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        int posicion = 0;
        Pattern pattern = Pattern.compile("([A-Z]{4})([0-9]{6})([A-Z]|\\d){3}");
        //Pattern pattern = Pattern.compile("");
         String input;
        while ((input = br.readLine()) != null) {

            Matcher m = pattern.matcher(input);

            if (m.find()) {
                System.out.println(m.group());
                posicion++;
            }
        }
        br.close();
        System.out.println("Total: " + posicion);
    }
    
}
