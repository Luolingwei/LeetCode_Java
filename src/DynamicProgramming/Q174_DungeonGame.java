package DynamicProgramming;

import java.util.*;

public class Q174_DungeonGame {

    public static void main(String[] args){
        Q174_DungeonGame a=new Q174_DungeonGame();
        System.out.println(a.calculateMinimumHP(new int [][]{{-2,-3,3},{-5,-10,1},{10,30,-5}}));
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int m=dungeon.length;
        int n=dungeon[0].length;
        int [][] dp=new int[m+1][n+1];
        for (int i=0;i<m+1;i++)
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        dp[m][n-1]=1;
        dp[m-1][n]=1;
        for (int i=m-1;i>=0;i--){
            for (int j=n-1;j>=0;j--){
                dp[i][j]=Math.max(1,Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j]);
            }
        }

    return dp[0][0];

    }


}