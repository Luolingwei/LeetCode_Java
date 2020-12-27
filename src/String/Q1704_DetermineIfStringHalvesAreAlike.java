package String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q1704_DetermineIfStringHalvesAreAlike {

    public static void main(String[] args) {

        System.out.println(halvesAreAlike("book"));
        System.out.println(halvesAreAlike("textbook"));
        System.out.println(halvesAreAlike("MerryChristmas"));

    }
    public static boolean halvesAreAlike(String s) {
        Set<Character> targets = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int l = 0, r = 0, L = s.length();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (targets.contains(c)) {
                if (i+1<=L/2) l++;
                else r++;
            }
        }
        return l==r;
    }
}
