package SlidingWindow;

import java.util.LinkedList;

public class Q1438_LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit {

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1,8,6,10},8));
    }

    public static int longestSubarray(int[] nums, int limit) {
        LinkedList<Integer> minQ = new LinkedList<>();
        LinkedList<Integer> maxQ = new LinkedList<>();
        int j = 0, res = 0;
        for (int i=0;i<nums.length;i++){
            while (!minQ.isEmpty() && nums[i]<nums[minQ.getLast()])
                minQ.pollLast();
            while (!maxQ.isEmpty() && nums[i]>nums[maxQ.getLast()])
                maxQ.pollLast();
            minQ.offerLast(i);
            maxQ.offerLast(i);
            while (nums[maxQ.getFirst()]-nums[minQ.getFirst()]>limit){
                if (nums[maxQ.getFirst()]==nums[i])
                    j = minQ.pollFirst()+1;
                else
                    j = maxQ.pollFirst()+1;
            }
            res = Math.max(res,i-j+1);
        }
        return res;
    }

}
