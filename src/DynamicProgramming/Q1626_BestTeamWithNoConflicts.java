package DynamicProgramming;

import java.util.Arrays;

public class Q1626_BestTeamWithNoConflicts {

    public static void main(String[] args) {
        Q1626_BestTeamWithNoConflicts a = new Q1626_BestTeamWithNoConflicts();
        System.out.println(a.bestTeamScore(new int[]{1,3,5,10,15}, new int[]{1,2,3,4,5}));
        System.out.println(a.bestTeamScore(new int[]{4,5,6,5}, new int[]{2,1,2,1}));
        System.out.println(a.bestTeamScore(new int[]{1,2,3,5}, new int[]{8,9,10,1}));
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] team = new int[n][2];
        for (int i=0; i<n; i++) {
            team[i][0] = ages[i];
            team[i][1] = scores[i];
        }
        Arrays.sort(team, (a, b) -> a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        int[] new_scores = new int[n];

        for (int i=0; i<n; i++) new_scores[i] = team[i][1];
        return maxIncrSum(new_scores);
    }

    private int maxIncrSum(int[] scores) {
        int n = scores.length, res = scores[0];
        int[] dp = scores.clone();
        for (int i=1; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (scores[j]<=scores[i] && dp[j]+scores[i]>dp[i])
                    dp[i] = dp[j]+scores[i];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
