package DynamicProgramming;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Q1696_JumpGameVI {

    public static void main(String[] args) {
        System.out.println(maxResult(new int[]{1,-1,-2,4,-7,3},2));
        System.out.println(maxResult(new int[]{10,-5,-2,4,0,3},3));
        System.out.println(maxResult(new int[]{1,-5,-20,4,-1,3,-6,-3},2));
    }

    public static int maxResult(int[] nums, int k) {
        int N = nums.length;
        int[] dp = new int[N];
        dp[0] = nums[0];
        Deque<Integer> deque = new LinkedList<>(Arrays.asList(0));

        for (int i=1; i<N; i++) {
            dp[i] = nums[i] + dp[deque.getFirst()];
            while (!deque.isEmpty() && dp[i]>dp[deque.getLast()]) deque.removeLast();
            deque.addLast(i);
            if (i-deque.getFirst()==k) deque.removeFirst();
        }
        return dp[N-1];
    }
}
