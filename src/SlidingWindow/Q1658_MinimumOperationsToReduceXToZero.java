package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Q1658_MinimumOperationsToReduceXToZero {

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1,1,4,2,3}, 5));
        System.out.println(minOperations(new int[]{5,6,7,8,9}, 4));
        System.out.println(minOperations(new int[]{3,2,20,1,1,3}, 10));
        System.out.println(minOperations(new int[]{1,1}, 2));
        System.out.println(minOperations(new int[]{1,1}, 3));
    }

    // preSum memo
    public static int minOperations(int[] nums, int x) {
        int sumNums = 0, curs = 0;
        for (int n: nums) sumNums += n;
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0,-1);
        if (sumNums == x) return nums.length;
        int target = sumNums - x, maxWindowSize = 0;
        for (int i = 0; i<nums.length; i++){
            curs += nums[i];
            memo.put(curs,i);
            if (memo.containsKey(curs - target))
                maxWindowSize = Math.max(maxWindowSize, i-memo.get(curs - target));
        }
        return maxWindowSize>0?(nums.length-maxWindowSize):-1;
    }

    // sliding window
    public static int minOperations2(int[] nums, int x) {
        int sumNums = 0, curs = 0;
        for (int n: nums) sumNums += n;
        int target = sumNums - x, maxWindowSize = 0, l = 0;
        if (target == 0) return nums.length;
        if (target < 0) return -1;
        for (int r = 0; r<nums.length; r++){
            curs += nums[r];
            while (curs >= target) {
                if (curs == target) maxWindowSize = Math.max(maxWindowSize, r-l+1);
                curs -= nums[l];
                l++;
            }
        }
        return maxWindowSize>0?(nums.length-maxWindowSize):-1;
    }

}
