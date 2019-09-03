package DynamicProgramming;

import java.util.Arrays;

public class Q516_LongestPalindromicSubsequence {


    public static void main(String[] args){
        Q516_LongestPalindromicSubsequence a=new Q516_LongestPalindromicSubsequence();
        System.out.println((a.longestPalindromeSubseq("bbbab")));
    }

    public int longestPalindromeSubseq(String s) {
        int L=s.length();
        int [][] dp= new int [L][L];
        for (int gap=0;gap<L;gap++){
            for (int left=0;left<L-gap;left++){
                int right=left+gap;
                if (left==right)
                    dp[left][right]=1;
                else {
                    if (s.charAt(left)==s.charAt(right))
                        dp[left][right]=dp[left+1][right-1]+2;
                    else
                        dp[left][right]=Math.max(dp[left+1][right],dp[left][right-1]);
                }
            }
        }
        return dp[0][L-1];
    }
}
