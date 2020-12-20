package DynamicProgramming;

public class Q1690_StoneGameVII {

    public static void main(String[] args) {
        System.out.println(stoneGameVII(new int[]{5,3,1,4,2}));
        System.out.println(stoneGameVII(new int[]{7,90,5,1,100,10,10,2}));
    }

    public static int stoneGameVII(int[] stones) {
        int N = stones.length;
        int[] preS = new int[N+1];
        int[][] dp = new int[N][N];
        for (int i=1; i<N+1; i++) preS[i] = preS[i-1] + stones[i-1];

        for (int gap=1; gap<N; gap++)
            for (int l=0; l<N-gap; l++) {
                int r = l+gap;
                dp[l][r] = Math.max(preS[r+1]-preS[l+1]-dp[l+1][r],preS[r]-preS[l]-dp[l][r-1]);
            }
        return dp[0][N-1];
    }

}
