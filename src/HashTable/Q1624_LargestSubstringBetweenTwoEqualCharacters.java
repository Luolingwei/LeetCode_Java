package HashTable;

import java.util.HashMap;
import java.util.Map;

public class Q1624_LargestSubstringBetweenTwoEqualCharacters {

    public static void main(String[] args) {
        System.out.println(maxLengthBetweenEqualCharacters("aa"));
        System.out.println(maxLengthBetweenEqualCharacters("abca"));
        System.out.println(maxLengthBetweenEqualCharacters("cbzxy"));
        System.out.println(maxLengthBetweenEqualCharacters("cabbac"));
    }

    public static int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> memo = new HashMap<>();
        int res = -1;
        for (int i=0; i<s.length();i++) {
            char c = s.charAt(i);
            if (!memo.containsKey(c)) memo.put(c,i);
            else res = Math.max(res,i-memo.get(c)-1);
        }
        return res;
    }
}
