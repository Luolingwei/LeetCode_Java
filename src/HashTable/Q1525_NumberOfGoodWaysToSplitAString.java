package HashTable;


public class Q1525_NumberOfGoodWaysToSplitAString {


    public static void main(String[] args) {
        System.out.println(numSplits("aacaba"));
        System.out.println(numSplits("abcd"));
        System.out.println(numSplits("aaaaa"));
        System.out.println(numSplits("acbadbaada"));
    }

    public static int numSplits(String s) {
        int[] A = new int[26], B = new int[26];
        int uniqueA = 0, uniqueB = 0, res = 0;
        for (char c: s.toCharArray()) {
            if (B[c-'a']==0) uniqueB++;
            B[c-'a'] ++;
        }
        for (char c: s.toCharArray()) {
            int idx = c-'a';
            if (A[idx] == 0) uniqueA++;
            A[idx] ++;
            B[idx] --;
            if (B[idx] == 0) uniqueB--;
            if (uniqueA == uniqueB) res++;
        }
        return res;
    }



}
