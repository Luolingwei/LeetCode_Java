package TwoPointers;

public class Q1793_MaximumScoreOfAGoodSubarray {


    public static void main(String[] args) {
        System.out.println(maximumScore(new int[]{1,4,3,7,4,5},3));
        System.out.println(maximumScore(new int[]{5,5,4,5,4,1,1,1},0));
    }


    public static int maximumScore(int[] nums, int k) {
        int l = k, r = k;
        int minN = nums[k], res = nums[k];
        while (l-1>=0 || r+1<nums.length) {
            int leftN = Integer.MIN_VALUE, rightN = Integer.MIN_VALUE;
            if (l-1>=0) leftN = nums[l-1];
            if (r+1<nums.length) rightN = nums[r+1];
            if (leftN>rightN) {
                minN = Math.min(minN, leftN);
                l--;
            } else {
                minN = Math.min(minN, rightN);
                r++;
            }
            res = Math.max(res, (r-l+1)*minN);
        }
        return res;
    }
}
