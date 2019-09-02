package HashTable;

import java.util.*;

public class Q3_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args){
        Q3_LongestSubstringWithoutRepeatingCharacters a=new Q3_LongestSubstringWithoutRepeatingCharacters();
        System.out.println(a.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(a.lengthOfLongestSubstring("bbbbb"));
        System.out.println(a.lengthOfLongestSubstring("pwwkew"));
        System.out.println(a.lengthOfLongestSubstring("tmmzuxt"));

    }

    public int lengthOfLongestSubstring(String s) {
        int maxl=0,left=0;
        Map<Character,Integer> dic=new HashMap<>();
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if (dic.containsKey(c) && dic.get(c)>=left)
                left=dic.get(c)+1;
            dic.put(c,i);
            maxl=Math.max(maxl,i-left+1);
        }
        return maxl;

    }
}
