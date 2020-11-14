package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Q76_MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
        System.out.println(minWindow("aa","aa"));
        System.out.println(minWindow("a","a"));
    }


    public static String minWindow(String s, String t) {

        Map<Character, Integer> need_chars = new HashMap<>();
        for (char c: t.toCharArray()) need_chars.put(c,need_chars.getOrDefault(c,0)+1);
        int need_num = t.length(), l = 0, min_l = s.length()+1;
        String res = "";
        for (int r=0; r<s.length(); r++) {
            char c = s.charAt(r);
            int cur_need = need_chars.getOrDefault(c,0);
            need_chars.put(c, cur_need-1);
            if (cur_need>0) need_num--;
            while (need_num==0){
                if (r-l+1<min_l){
                    min_l = r-l+1;
                    res = s.substring(l,r+1);
                }
                c = s.charAt(l);
                cur_need = need_chars.getOrDefault(c,0);
                need_chars.put(c, cur_need+1);
                if (cur_need==0) need_num++;
                l++;
            }
        }
        return res;
    }

}
