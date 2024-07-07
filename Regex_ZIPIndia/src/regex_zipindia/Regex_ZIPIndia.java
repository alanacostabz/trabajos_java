package regex_zipindia;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex_ZIPIndia {

    public static void main(String[] args) {
        // TODO code application logic here
        List<String> zips = new ArrayList<String>();
        //Valid ZIP codes
        zips.add("571120");

        //Invalid ZIP codes
        zips.add("4567889");

        String RegExZip = "^[1-9]{3}\\s?[0-9]{3}$";
        Pattern p = Pattern.compile(RegExZip);

        
        for (int i = 0; i < zips.size(); i++) {
            Matcher m = p.matcher(zips.get(i));

            if (m.find()) {
                System.out.println("The zip matches: " + m.matches() + " in " + zips.get(i));
            } else {
                System.out.println("False in " + zips.get(i));
            }
        }
    }
    
}
