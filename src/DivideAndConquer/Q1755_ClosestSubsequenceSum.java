package DivideAndConquer;

import java.util.*;

public class Q1755_ClosestSubsequenceSum {


    public static void main(String[] args) {
        Q1755_ClosestSubsequenceSum a = new Q1755_ClosestSubsequenceSum();
        System.out.println(a.minAbsDifference(new int[]{5,-7,3,5},6));
        System.out.println(a.minAbsDifference(new int[]{7,-9,15,-2},-5));
        System.out.println(a.minAbsDifference(new int[]{1,2,3},-7));
    }


    public int minAbsDifference(int[] nums, int goal) {
        Set<Integer> m1 = new HashSet<>();
        TreeSet<Integer> m2 = new TreeSet<>();

        dfs(Arrays.copyOfRange(nums,0, nums.length/2),0,0, m1);
        dfs(Arrays.copyOfRange(nums, nums.length/2, nums.length),0,0, m2);

        int res = Integer.MAX_VALUE;
        for (int x: m1) {
            int y = goal - x;
            Integer larger = m2.ceiling(y);
            Integer smaller =  m2.floor(y);
            if (larger!=null) res = Math.min(res, larger - y);
            if (smaller!=null) res = Math.min(res, y - smaller);
        }
        return res;
    }

    private void dfs(int[] nums, int pos, int curS, Set<Integer> memo) {
        if (pos == nums.length) {
            memo.add(curS);
            return;
        }
        dfs(nums, pos+1, curS+nums[pos], memo);
        dfs(nums, pos+1, curS, memo);
    }
}
