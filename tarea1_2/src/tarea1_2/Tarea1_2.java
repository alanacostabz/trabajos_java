/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author bryan
 */
public class Tarea1_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            List<String> input = new ArrayList<String>();
        input.add("+1 (662) 123-4567");
        input.add("+54 (662) 123-4567");
        input.add("+33 (662) 123-456");
        input.add("+81 (333) 674-4567");
        input.add("+33 (662) 123-456");
        input.add("+54 (333) 1423-4567");
        input.add("+44 (333) 123-4567");
        input.add("+33 (333) 1235-4567");
        input.add("+52 (662) 335-1163");
        
        String regex = "^\\+(1|52|54|81|44)\\s([(]\\d{3}[)])\\s(\\d{3})-(\\d{4})$";
        
	Pattern pattern = Pattern.compile(regex);
        
           for (int i = 0; i < input.size(); i++) {
               Matcher matcher = pattern.matcher(input.get(i));
            while (matcher.find()) {
                String marcacion = input.get(i).substring(1, 3);
                
                switch (marcacion) {
                    case "1 ":
                        System.out.println("found: " + matcher.group() + " from USA");
                        break;
                    case "44":
                        System.out.println("found: " + matcher.group() + " from UK");
                        break;
                    case "52":
                        System.out.println("found: " + matcher.group() + " from Mexico");
                        break;
                    case "54":
                        System.out.println("found: " + matcher.group() + " from Argentina");
                        break;
                    case "81":
                        System.out.println("found: " + matcher.group() + " from Japan");
                        break;
                    default:
                        System.out.println("...");
                }
              
        
        }
           }
    }
    
}
