package String;

import java.util.ArrayList;
import java.util.List;

public class Q1694_ReformatPhoneNumber {

    public static void main(String[] args) {
        System.out.println(reformatNumber("1-23-45 6"));
        System.out.println(reformatNumber("123 4-567"));
        System.out.println(reformatNumber("123 4-5678"));
        System.out.println(reformatNumber("12"));
        System.out.println(reformatNumber("--17-5 229 35-39475 "));
    }

    public static String reformatNumber(String number) {
        number = number.replace("-", "").replace(" ", "");

        List<String> res = new ArrayList<>();
        for (int i=0;i<number.length();i+=3) {
            if (number.length()-i==4) {
                res.add(number.substring(i,i+2));
                res.add(number.substring(i+2,i+4));
                break;
            } else {
                res.add(number.substring(i,Math.min(number.length(),i+3)));
            }
        }
        return String.join("-", res);
    }

}
