/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoformmddyyyy;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author bryan
 */
public class DemoForMMDDYYYY {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
//       
        
        String DATE_PATTERN= "(^(((0*[1-9]|1[0-9]|2[0-8])\\/(0*[1-9]|1[012]))|((29|30|31)\\/(0*[13578]|1[02]))|((29|30)\\/(0*[4,6,9]|11)))\\/(19|[2-9][0-9])\\d\\d$)|(^29\\/02\\/(19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)";
       // Tarea
        //^(?<month>[0-3]?[0-9])\/(?<day>[0-3]?[0-9])\/(?<year>(?:[0-9]{2})?[0-9]{2})$
      
        String dates[] = {"29/02/2021", "29/02/2020", "2/8/2018", "01/01/2000"};

        Pattern p = Pattern.compile(DATE_PATTERN);
        
        
        for (int i = 0; i < dates.length; i++) {
           Matcher m = p.matcher(dates[i]); 
           
            if (m.find()) {
                System.out.println("The date matches: " + m.matches() + " in " + dates[i]);
            } else {
                System.out.println("False in " + dates[i]);
            }
        }

    }
    
}
