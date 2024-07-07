/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;

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
public class Tarea1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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

        
        Map<String,String> formato = new HashMap<String,String>();
        
        formato.put("Estados Unidos","^\\+(1)\\s([(]\\d{3}[)])\\s(\\d{3})-(\\d{4})$");
        formato.put("Argentina","^\\+(54)\\s([(]\\d{3}[)])\\s(\\d{3})-(\\d{4})$");
        formato.put("Japon","^\\+(81)\\s([(]\\d{3}[)])\\s(\\d{3})-(\\d{4})$");
        formato.put("Reino Unido","^\\+(81)\\s([(]\\d{3}[)])\\s(\\d{3})-(\\d{4})$");
        formato.put("Mexico","^\\+(52)\\s([(]\\d{3}[)])\\s(\\d{3})-(\\d{4})$");
        
       for (Map.Entry<String, String> regex : formato.entrySet()) {    
	Pattern pattern = Pattern.compile(regex.getValue());
        
           for (int i = 0; i < input.size(); i++) {
               Matcher matcher = pattern.matcher(input.get(i));
            while (matcher.find()) {
              System.out.println("found: " + matcher.group() + " from " + regex.getKey());
        }
        }
           }
    }
}
    


