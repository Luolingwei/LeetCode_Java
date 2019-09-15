package Array;

import java.util.*;

public class QAmazon_ClosestTwoSum {

    public static void main(String[] args){
        QAmazon_ClosestTwoSum a=new QAmazon_ClosestTwoSum();
        System.out.println(Arrays.toString(a.FindClosest(new int []{2, 7, 11, 15},9)));
        System.out.println(Arrays.toString(a.FindClosest(new int []{1,6,4,2},11)));
        System.out.println(Arrays.toString(a.FindClosest(new int []{6,4,0,29,5,5,1,2},19)));
        System.out.println(Arrays.toString(a.FindClosest(new int []{1,3},2)));
    }

    public int [] FindClosest(int [] nums, int target){
        Arrays.sort(nums);
        int l=0,r=nums.length-1;
        int mingap=Integer.MAX_VALUE,n1=0,n2=0;
        while (l<r){
            int v=nums[l]+nums[r];
            if (Math.abs(v-target)<mingap){
                mingap=Math.abs(v-target);
                n1=nums[l];
                n2=nums[r];
            }
            if (v==target)
                return new int[]{n1,n2};
            else if (v>target)
                r-=1;
            else
                l+=1;
        }
        return new int[] {n1,n2};
    }
}