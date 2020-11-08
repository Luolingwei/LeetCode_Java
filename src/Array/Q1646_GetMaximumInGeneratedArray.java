package Array;

public class Q1646_GetMaximumInGeneratedArray {

    public static void main(String[] args) {
        System.out.println(getMaximumGenerated(7));
        System.out.println(getMaximumGenerated(2));
        System.out.println(getMaximumGenerated(3));
    }

    public static int getMaximumGenerated(int n) {
        if (n==1) return 1;
        int[] nums = new int[n+1];
        nums[1] = 1;
        int res = 0;
        for (int i=2; i<n+1; i++){
            if (i%2==0)
                nums[i] = nums[i/2];
            else
                nums[i] = nums[i/2] + nums[i/2+1];
            res = Math.max(res,nums[i]);
        }
        return res;
    }
}
