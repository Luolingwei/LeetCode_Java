package HashTable;

import java.util.*;

public class Q1657_DetermineIfTwoStringsAreClose {


    public static void main(String[] args) {
        System.out.println(closeStrings("abc","bca"));
        System.out.println(closeStrings("a","aa"));
        System.out.println(closeStrings("cabbba","abbccc"));
        System.out.println(closeStrings("cabbba", "aabbss"));
    }

    public static boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> map1 = new HashMap<>();
        for (char c: word1.toCharArray()) map1.put(c, map1.getOrDefault(c,0)+1);
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c: word2.toCharArray()) map2.put(c, map2.getOrDefault(c,0)+1);
        List<Integer> l1 = new ArrayList<>(map1.values());
        List<Integer> l2 = new ArrayList<>(map2.values());
        Collections.sort(l1);
        Collections.sort(l2);
        return (map1.keySet().equals(map2.keySet())) && (l1.equals(l2));
    }

}
