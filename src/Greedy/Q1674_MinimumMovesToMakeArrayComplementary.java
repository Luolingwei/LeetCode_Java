package Greedy;

import java.util.Arrays;

public class Q1674_MinimumMovesToMakeArrayComplementary {


    public static void main(String[] args) {
        System.out.println(minMoves(new int[]{1,2,4,3}, 4));
        System.out.println(minMoves(new int[]{1,2,2,1}, 2));
        System.out.println(minMoves(new int[]{1,2,1,2}, 2));
    }


    public static int minMoves(int[] nums, int limit) {

        int[] diff = new int[2*limit+2];
        Arrays.fill(diff,0);
        int n = nums.length;
        for (int i=0; i<n/2; i++) {
            int a = nums[i], b = nums[n-1-i];
            diff[2] += 2;
            diff[Math.min(a,b)+1] -= 1;
            diff[a+b] -= 1;
            diff[a+b+1] += 1;
            diff[Math.max(a,b)+limit+1] += 1;
        }

        int cur_move = 0, res = Integer.MAX_VALUE;
        for (int x=2; x<2*limit+1; x++) {
            cur_move += diff[x];
            res = Math.min(res,cur_move);
        }
        return res;

    }


}
