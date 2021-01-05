package BinarySearch;


public class Q1712_WaysToSplitArrayIntoThreeSubarrays {


    public static void main(String[] args) {
        Q1712_WaysToSplitArrayIntoThreeSubarrays a = new Q1712_WaysToSplitArrayIntoThreeSubarrays();
        System.out.println(a.waysToSplit(new int[]{1,1,1}));
        System.out.println(a.waysToSplit(new int[]{1,2,2,2,5,0}));
        System.out.println(a.waysToSplit(new int[]{3,2,1}));
        System.out.println(a.waysToSplit(new int[]{0,3,3}));
        System.out.println(a.waysToSplit(new int[]{2,8,10,0,2}));
        System.out.println(a.waysToSplit(new int[]{0,0,0}));
    }


    public int waysToSplit(int[] nums) {
        int[] preS = nums.clone();
        int L = nums.length, mod = 1000000007;
        for (int i=1; i<L; i++) preS[i] += preS[i-1];

        int left = 0, total = preS[L-1], res = 0;
        for (int i=0; i<L; i++) {
            left += nums[i];
            total -= nums[i];
            int low = 2*left, high = left + total/2;
            if (low>high) break;
            int low_idx = search_low(preS, low);
            int high_idx = search_high(preS, high);
            res = (res + Math.max(0, Math.min(L-2, high_idx) - Math.max(i+1, low_idx) + 1))%mod;
        }
        return res%mod;
    }

    public int search_low(int[]preS, int low) {
        int l = 0, r = preS.length-1;
        while (l<r) {
            int mid = (l+r)/2;
            if (preS[mid]<low)
                l = mid+1;
            else
                r = mid;
        }
        return l;
    }

    public int search_high(int[]preS, int high) {
        int l = 0, r = preS.length-1;
        while (l<r) {
            int mid = (l+r+1)/2;
            if (preS[mid]>high)
                r = mid-1;
            else
                l = mid;
        }
        return l;
    }
}
