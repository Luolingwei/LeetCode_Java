package DynamicProgramming;

import java.util.Arrays;

public class Q1039_MinimumScoreTriangulationofPolygon {

    public static void main(String[] args){
        Q1039_MinimumScoreTriangulationofPolygon a=new Q1039_MinimumScoreTriangulationofPolygon();
        System.out.println(a.minScoreTriangulation(new int []{3,7,4,5}));
    }

    public int minScoreTriangulation(int[] A) {
        int N=A.length;
        int [][] dp=new int[N][N];
        for (int i=0;i<N;i++)
            Arrays.fill(dp[i],0);
        for (int gap=2;gap<=N-1;gap++){
            for (int left=0;left<N-gap;left++){
                int right=left+gap;
                int temp=Integer.MAX_VALUE;
                for (int k=left+1;k<right;k++){
                    temp=Math.min(temp,dp[left][k]+A[left]*A[k]*A[right]+dp[k][right]);
                }
                dp[left][right]=temp;
            }
        }
        return dp[0][N-1];
    }
}
