package TwoPointers;

import java.util.*;

public class Q15_3Sum {

    public static void main(String[] args){
        Q15_3Sum a=new Q15_3Sum();
        System.out.println(a.threeSum(new int []{1,-1,-1,0}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        int len=nums.length;
        Arrays.sort(nums);
        for (int i=0;i<len-2;i++){
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int l=i+1,r=len-1;
            while (l<r){
                int curS=nums[l]+nums[i]+nums[r];
                if (curS==0){
                    ans.add(new ArrayList<>(Arrays.asList(nums[l],nums[i],nums[r])));
                    while (l<r && nums[r]==nums[r-1]){
                        r-=1;
                    }
                    while (l<r && nums[l]==nums[l+1]){
                        l+=1;
                    }
                    l+=1;r-=1;
                }
                else if (curS<0){
                    l+=1;
                }
                else{
                    r-=1;
                }

            }
        }

    return ans;

    }

}