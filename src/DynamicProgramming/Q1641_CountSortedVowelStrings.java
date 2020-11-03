package DynamicProgramming;

import java.util.Arrays;

public class Q1641_CountSortedVowelStrings {

    public static void main(String[] args) {
        System.out.println(countVowelStrings(1));
        System.out.println(countVowelStrings(2));
        System.out.println(countVowelStrings(33));
    }

    public static int countVowelStrings(int n) {
        int[] memo = new int[]{0,1,1,1,1,1};
        for (int i=0; i<n-1;i++)
            for (int j=1; j<6; j++)
                memo[j] += memo[j-1];
        return Arrays.stream(memo).sum();
    }
}
