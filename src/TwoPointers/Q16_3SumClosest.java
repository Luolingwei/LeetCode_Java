package TwoPointers;

import java.util.Arrays;

public class Q16_3SumClosest {

    public static void main(String[] args){
        Q16_3SumClosest a=new Q16_3SumClosest();
        System.out.println(a.threeSumClosest(new int []{-1, 2, 1, -4},1));
        System.out.println(a.threeSumClosest(new int []{-3,-2,-5,3,-4},-1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int L=nums.length;
        long res=Integer.MAX_VALUE;
        for (int a=0;a<nums.length-2;a++){
            if (a>0 && nums[a]==nums[a-1])
                continue;
            int b=a+1,c=L-1;
            while (b<c){
                int s=nums[a]+nums[b]+nums[c];
                if ((Math.abs(s-target))<(Math.abs(res-target)))
                    res=s;
                if (s<target)
                    b+=1;
                else if (s>target)
                    c-=1;
                else
                    return s;
            }
        }
        return (int)res;
    }
}