/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regex_demoforhtml;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author bryan
 */
public class Regex_DemoForHTML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      //En java si se requiere poner una comilla doble dentro de un string se
        //ante pone una diagonal inversa
        String HTML_PATTERN = "<(\"[^\"]\"|'[^']'|[^'\">])*>";
       
        String htmlTag1 = "<br>";
        String htmlTag2 = "<body"; //Invalid tag

        Pattern p = Pattern.compile(HTML_PATTERN);
        Matcher m = p.matcher(htmlTag1);

        System.out.println("The html tag matches: " + m.matches());
        
        m = p.matcher(htmlTag2);

        System.out.println("The html tag matches: " + m.matches());
    }
}

    
