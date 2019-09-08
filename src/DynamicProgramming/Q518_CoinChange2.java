package DynamicProgramming;

import java.util.Arrays;

public class Q518_CoinChange2 {

    public static void main(String[] args){
        Q518_CoinChange2 a=new Q518_CoinChange2();
        System.out.println(a.change(5,new int []{1,2,5}));
        System.out.println(a.change(3, new int []{2}));
        System.out.println(a.change(10, new int []{10}));
    }

    public int change(int amount, int[] coins) {
        int [] dp=new int [amount+1];
        Arrays.fill(dp,0);
        dp[0]=1;
        for (int c:coins){
            for (int j=c;j<amount+1;j++)
                dp[j]+=dp[j-c];
        }
        return dp[amount];
    }
}
