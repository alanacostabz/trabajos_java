package regex_reto3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex_Reto3 {

    public static void main(String[] args) {
        List<String> zips = new ArrayList<String>();
        //Valid ZIP codes
        zips.add("M1 1AQ");
        zips.add("B28 9EU");
         zips.add("W2 2SZ");

        //Invalid ZIP codes
        zips.add("aWC2H 7LT");
        zips.add("WC2H 7LTa");
        zips.add("WC2H1AQ");


        String RegExZip = "^([A-Z]{1,2}\\d[A-Z\\d]?\\s\\d[A-Z]{2}|[GIR\\s\\d[A-Z]{2}])$";
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
