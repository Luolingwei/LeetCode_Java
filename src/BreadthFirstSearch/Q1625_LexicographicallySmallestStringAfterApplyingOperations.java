package BreadthFirstSearch;

import java.util.*;

public class Q1625_LexicographicallySmallestStringAfterApplyingOperations {


    public static void main(String[] args) {
        Q1625_LexicographicallySmallestStringAfterApplyingOperations a = new Q1625_LexicographicallySmallestStringAfterApplyingOperations();
        System.out.println(a.findLexSmallestString("5525",9,2));
        System.out.println(a.findLexSmallestString("74", 5 ,1));
        System.out.println(a.findLexSmallestString("0011", 4 ,2));
        System.out.println(a.findLexSmallestString("43987654", 7,3));
    }

    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> q = new LinkedList<>(Arrays.asList(s));
        Set<String> visited = new HashSet<>();
        String res = s;
        while (!q.isEmpty()) {
            String curs = q.poll();
            if (!visited.contains(curs)) {
                visited.add(curs);
                if (res.compareTo(curs)>0) res = curs;
                q.add(rotate(curs,b));
                q.add(add(curs,a));
            }
        }
        return res;
    }

    private String rotate(String s, int b) {
        return s.substring(s.length()-b,s.length()) + s.substring(0,s.length()-b);
    }

    private String add(String s, int a) {
        String res = "";
        for (int i=0; i<s.length(); i++) {
            if (i%2!=0) res += (char)((s.charAt(i) - '0' + a) % 10 + '0');
            else res += s.charAt(i);
        }
        return res;
    }

}
