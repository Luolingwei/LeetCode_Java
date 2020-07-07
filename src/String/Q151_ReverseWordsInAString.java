package String;

import java.util.Arrays;
import java.util.Collections;

public class Q151_ReverseWordsInAString {

    public static void main(String[] args) {
        System.out.println(reverseWords("   hello    world   !!  "));
    }

    public static String reverseWords(String s) {
        String[] result = s.trim().split(" +");
        Collections.reverse(Arrays.asList(result));
        return String.join(" ",result);
    }

}
