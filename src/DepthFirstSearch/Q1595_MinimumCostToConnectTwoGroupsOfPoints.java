package DepthFirstSearch;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class Q1595_MinimumCostToConnectTwoGroupsOfPoints {

    public static void main(String[] args) {
        Q1595_MinimumCostToConnectTwoGroupsOfPoints a = new Q1595_MinimumCostToConnectTwoGroupsOfPoints();
        System.out.println(a.connectTwoGroups(asList(asList(93,56,92), asList(53,44,18), asList(86,44,69), asList(54,60,30))));
    }

    private int[][] memo = new int[13][4096];

    public int connectTwoGroups(List<List<Integer>> cost) {
        int m = cost.size(), n = cost.get(0).size();
        int[] min_cols = new int[n];
        Arrays.fill(min_cols, Integer.MAX_VALUE);
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                min_cols[j] = Math.min(min_cols[j],cost.get(i).get(j));
        return dfs(cost, min_cols, 0, 0);
    }

    public int dfs(List<List<Integer>> cost, int[] min_cols, int i, int visited) {
        int m = cost.size(), n = cost.get(0).size();
        if (memo[i][visited]!=0) return memo[i][visited];
        int res = i>=m? 0:Integer.MAX_VALUE;
        if (i>=m){
            for (int j=0; j<n; j++)
                if ((1<<j&visited) == 0)
                    res += min_cols[j];
        } else {
            for (int j=0; j<n; j++)
                res = Math.min(res, cost.get(i).get(j)+dfs(cost, min_cols, i+1, visited|1<<j));
        }
        memo[i][visited] = res;
        return res;
    }
}
