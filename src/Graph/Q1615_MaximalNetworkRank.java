package Graph;

import java.util.HashSet;
import java.util.Set;

public class Q1615_MaximalNetworkRank {

    public static void main(String[] args) {
        System.out.println(maximalNetworkRank(4, new int[][]{{0,1},{0,3},{1,2},{1,3}}));
        System.out.println(maximalNetworkRank(5, new int[][]{{0,1},{0,3},{1,2},{1,3},{2,3},{2,4}}));
    }

    public static int maximalNetworkRank(int n, int[][] roads) {

        Set<Integer>[] memo = new Set[n];
        for (int i=0; i<n; i++) memo[i] = new HashSet<>();

        int res = 0;
        for (int[] road: roads) {
            memo[road[0]].add(road[1]);
            memo[road[1]].add(road[0]);
        }

        for (int i=0; i<n; i++)
            for (int j=i+1; j<n; j++){
                int minus = memo[i].contains(j)? 1:0;
                res = Math.max(res, memo[i].size() + memo[j].size() - minus);
            }
        return res;
    }
}