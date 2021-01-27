package Greedy;

public class Q1737_ChangeMinimumCharactersToSatisfyOneOfThreeConditions {


    public static void main(String[] args) {
        System.out.println(minCharacters("aba", "caa"));
        System.out.println(minCharacters("dabadd", "cda"));
        System.out.println(minCharacters("azzzz", "bzzzz"));
        System.out.println(minCharacters("a", "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
    }

    public static int minCharacters(String a, String b) {
        int m = a.length(), n = b.length(), res = m+n;
        int[] Ca = new int[26], Cb = new int[26];
        for (char c: a.toCharArray()) Ca[c-'a']++;
        for (char c: b.toCharArray()) Cb[c-'a']++;
        for (int i=0; i<26; i++) {
            res = Math.min(res, m+n-Ca[i]-Cb[i]);
            if (i>0) {
                Ca[i] += Ca[i-1];
                Cb[i] += Cb[i-1];
            }
            if (i!=25) {
                res = Math.min(res, m-Ca[i]+Cb[i]);
                res = Math.min(res, n-Cb[i]+Ca[i]);
            }
        }
        return res;
    }
}
