package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Q76_MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();
        char curC, leftC;
        int need = t.length();
        int l=0, length=Integer.MAX_VALUE;
        String res = "";
        for (char c: t.toCharArray()) count.put(c,count.getOrDefault(c,0)+1);
        for (int i=0;i<s.length();i++){
            curC = s.charAt(i);
            if (count.getOrDefault(curC,0)>0) need-=1;
            count.put(curC, count.getOrDefault(curC,0)-1);
            if (need==0){
                leftC = s.charAt(l);
                while (count.get(leftC)<0){
                    count.put(leftC, count.get(leftC)+1);
                    leftC = s.charAt(++l);
                }
                if (i-l+1<length) {
                    res = s.substring(l,i+1);
                    length = i-l+1;
                }
                count.put(leftC, count.get(leftC)+1);
                l++;
                need++;
            }
        }
        return res;
    }

}
