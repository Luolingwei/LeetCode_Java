package DynamicProgramming;

import java.util.Arrays;

public class Q322_CoinChange {

    public static void main(String[] args){
        Q322_CoinChange a=new Q322_CoinChange();
        System.out.println(a.coinChange(new int []{1,2,5},11));
        System.out.println(a.coinChange(new int []{2},3));
        System.out.println(a.coinChange(new int []{474,83,404,3},264));
    }

    public int coinChange(int[] coins, int amount) {
        int [] dp=new int [amount+1];
        Arrays.fill(dp,amount+1);
        Arrays.sort(coins);
        dp[0]=0;
        for (int i=1;i<amount+1;i++){
            int temp=amount+1;
            for (int c:coins){
                if (i-c>=0)
                    temp=Math.min(temp,dp[i-c]+1);
                else
                    break;
            }
            dp[i]=temp;
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}