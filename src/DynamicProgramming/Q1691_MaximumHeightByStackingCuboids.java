package DynamicProgramming;

import java.util.Arrays;

public class Q1691_MaximumHeightByStackingCuboids {

    public static void main(String[] args) {
        System.out.println(maxHeight(new int[][]{{12,76,13},{68,55,30},{48,85,52},{91,7,41},{29,65,35}}));
        System.out.println(maxHeight(new int[][]{{50,45,20},{95,37,53},{45,23,12}}));
    }


    public static int maxHeight(int[][] cuboids) {

        int N = cuboids.length, res = 0;
        for (int[] c: cuboids) Arrays.sort(c);
        Arrays.sort(cuboids, (x,y)->x[0]==y[0]? (x[1]==y[1]? x[2]-y[2]: x[1]-y[1]):x[0]-y[0]);

        int[] dp = new int[N];
        for (int j=0;j<N;j++) {
            dp[j] = cuboids[j][2];
            for (int i=0;i<j;i++) {
                if (cuboids[i][0]<=cuboids[j][0] && cuboids[i][1]<=cuboids[j][1] && cuboids[i][2]<=cuboids[j][2])
                    dp[j] = Math.max(dp[j], dp[i] + cuboids[j][2]);
            }
            res = Math.max(res,dp[j]);
        }
        return res;

    }
}
