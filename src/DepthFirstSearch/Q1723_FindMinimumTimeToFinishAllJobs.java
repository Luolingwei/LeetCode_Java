package DepthFirstSearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q1723_FindMinimumTimeToFinishAllJobs {


    public static void main(String[] args) {
        Q1723_FindMinimumTimeToFinishAllJobs a = new Q1723_FindMinimumTimeToFinishAllJobs();
        System.out.println(a.minimumTimeRequired(new int[]{3,2,3},3));
        System.out.println(a.minimumTimeRequired(new int[]{1,2,4,7,8},2));
        System.out.println(a.minimumTimeRequired(new int[]{46,13,54,51,38,49,54,67,26,78,33},10));
    }

    private int[] memo;

    private int res;

    public int minimumTimeRequired(int[] jobs, int k) {
        if (k==jobs.length) return Arrays.stream(jobs).max().getAsInt();
        memo = new int[k];
        res = Integer.MAX_VALUE;
        dfs(jobs,0,0,k);
        return res;
    }

    public void dfs(int[] jobs, int curIdx, int curMax, int k) {
        if (curMax>=res) return;
        if (curIdx==jobs.length) {
            res = Math.min(res, curMax);
            return;
        }
        Set<Integer> visited = new HashSet<>();
        for (int i=0; i<k; i++) {
            if (visited.contains(memo[i])) continue;
            visited.add(memo[i]);
            memo[i]+=jobs[curIdx];
            dfs(jobs, curIdx+1, Math.max(memo[i], curMax), k);
            memo[i]-=jobs[curIdx];
        }
    }
}
