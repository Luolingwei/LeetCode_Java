package DynamicProgramming;

public class Q1664_WaysToMakeAFairArray {


    public static void main(String[] args) {
        System.out.println(waysToMakeFair(new int[]{2,1,6,4}));
        System.out.println(waysToMakeFair(new int[]{1,1,1}));
        System.out.println(waysToMakeFair(new int[]{1,2,3}));

        System.out.println(waysToMakeFair2(new int[]{2,1,6,4}));
        System.out.println(waysToMakeFair2(new int[]{1,1,1}));
        System.out.println(waysToMakeFair2(new int[]{1,2,3}));
    }


    public static int waysToMakeFair(int[] nums) {
        int L = nums.length, res = 0;
        int[] odd = new int[L], even = new int[L];
        for (int i=0; i<L; i++) {
            if (i>0) {
                odd[i] += odd[i-1];
                even[i] += even[i-1];
            }
            if (i%2!=0) odd[i] += nums[i];
            else even[i] += nums[i];
        }

        for (int i=0; i<L; i++) {
            int preOdd = i>0?odd[i-1]:0;
            int afterOdd = even[L-1] - even[i];
            int preEven = i>0?even[i-1]:0;
            int afterEven = odd[L-1] - odd[i];
            if (preOdd+afterOdd==preEven+afterEven) res++;
        }
        return res;
    }


    public static int waysToMakeFair2(int[] nums) {
        int odds=0, evens=0, res=0;
        for (int i=0;i<nums.length;i++) {
            if (i%2==0) evens+=nums[i];
            else odds+=nums[i];
        }
        int [] pre = new int[]{0,0}, after = new int[]{evens,odds};
        for (int i=0;i<nums.length;i++) {
            after[i%2]-=nums[i];
            if (pre[0]+after[1]==pre[1]+after[0]) res++;
            pre[i%2]+=nums[i];
        }
        return res;
    }
}
