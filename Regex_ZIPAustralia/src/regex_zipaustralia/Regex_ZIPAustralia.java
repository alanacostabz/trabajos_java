package regex_zipaustralia;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex_ZIPAustralia {

    public static void main(String[] args) {
        // TODO code application logic here
        List<String> zips = new ArrayList<String>();
        //Valid ZIP codes
        zips.add("0200");
        zips.add("7321");
        zips.add("2415");

        //Invalid ZIP codes
        zips.add("0123");
        zips.add("012");
        zips.add("12345");

        String RegExZip = "^((0[289][0-9]{2})|([1345689][0-9]{3})|(2[0-8][0-9]{2})|(290[0-9])|(291[0-4])|(7[0-4][0-9]{2})|(7[8-9][0-9]{2}))$";
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
