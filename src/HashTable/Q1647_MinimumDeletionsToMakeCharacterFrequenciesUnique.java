package HashTable;

import java.util.*;

public class Q1647_MinimumDeletionsToMakeCharacterFrequenciesUnique {

    public static void main(String[] args) {
        System.out.println(minDeletions("aab"));
        System.out.println(minDeletions("aaabbbcc"));
        System.out.println(minDeletions("ceabaacb"));
        System.out.println(minDeletions("bbcebab"));
    }

    public static int minDeletions(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        Set<Integer> memo = new HashSet<>();
        int res = 0;
        for (char c: s.toCharArray())
            freq.put(c,freq.getOrDefault(c,0)+1);
        for (int f: freq.values()){
            while (memo.contains(f)){
                f--;
                res++;
            }
            if (f>0) memo.add(f);
        }
        return res;
    }

}
