package Graph;

import java.util.ArrayList;
import java.util.List;

public class Q1601_MaximumNumberOfAchievableTransferRequests {

    public static void main(String[] args) {
        Q1601_MaximumNumberOfAchievableTransferRequests a = new Q1601_MaximumNumberOfAchievableTransferRequests();
        System.out.println(a.maximumRequests1(5, new int[][]{{0,1},{1,0},{0,1},{1,2},{2,0},{3,4}}));
        System.out.println(a.maximumRequests1(3, new int[][]{{1,2},{1,2},{2,2},{0,2},{2,1},{1,1},{1,2}}));
        System.out.println(a.maximumRequests2(5, new int[][]{{0,1},{1,0},{0,1},{1,2},{2,0},{3,4}}));
        System.out.println(a.maximumRequests2(3, new int[][]{{1,2},{1,2},{2,2},{0,2},{2,1},{1,1},{1,2}}));
    }

    // solution 1, dfs to extract all subsets
    private List<List<Integer>> memo;

    public int maximumRequests1(int n, int[][] requests) {

        int L = requests.length;
        for (int k = L; k >0; k--) {
            memo = new ArrayList<>();
            dfs(L,0,k,new ArrayList<>());
            for (List<Integer> ridxs: memo) {
                int[] degree = new int[n];
                for (int ridx: ridxs) {
                    degree[requests[ridx][0]]--;
                    degree[requests[ridx][1]]++;
                }
                if (check(degree)) return k;
            }
        }
        return 0;
    }


    public void dfs (int L, int start, int k, List<Integer> path) {
        if (k==0) {
            memo.add(new ArrayList<>(path));
            return;
        }

        for (int i=start; i<L; i++) {
            path.add(i);
            dfs(L, i+1, k-1, path);
            path.remove(path.size()-1);
        }
    }

    public boolean check (int[] degree) {
        for (int d: degree)
            if (d!=0) return false;
        return true;
    }

    // solution 2, use bitmask to find all comb
    public int maximumRequests2(int n, int[][] requests) {

        int L = requests.length, res = 0;
        for (int mask = 0; mask<(1<<L); mask++) {

            int ones = Integer.bitCount(mask);
            if (ones<=res) continue;

            int[] degree = new int[n];
            for (int i=0; i<L; i++) {
                if ((mask&(1<<i)) != 0) {
                    degree[requests[i][0]]--;
                    degree[requests[i][1]]++;
                }
            }
            if (check(degree)) res = ones;
        }
        return res;
    }


}



