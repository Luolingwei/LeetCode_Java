package Array;

import java.util.*;


class Q1_TwoSum {

    public static void main(String[] args){
        Q1_TwoSum a=new Q1_TwoSum();
        System.out.println(a.twoSum(new int []{50,20,35,35,40,30,5,19},100));
        System.out.println(a.twoSum(new int []{90, 85, 75, 60, 120, 150, 125},250));
    }

    public List<Integer> twoSum(int [] movieDurations , int d) {
        int [][] nums=new int[movieDurations.length][2];
        for (int i=0;i<movieDurations.length;i++){
            nums[i]=new int[]{movieDurations[i],i};
        }
        Arrays.sort(nums,(a,b)->a[0]-b[0]);
        int target=d-30,maxS=0;
        List<Integer> ans=new ArrayList<>();
        int l=0,r=nums.length-1;
        while (l<r){
            int s=nums[l][0]+nums[r][0];
            if (s<=target){
                if (s>maxS){
                    maxS=s;
                    ans=new ArrayList<>(Arrays.asList(nums[l][1],nums[r][1]));
                }
                l+=1;
            }
            else
                r-=1;
        }
        return ans;

    }
}