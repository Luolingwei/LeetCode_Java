package Array;

import java.util.*;


class Q1_TwoSum {

    public static void main(String[] args){
        Q1_TwoSum a=new Q1_TwoSum();
        System.out.println(a.twoSum(new ArrayList<>(Arrays.asList(50,20,35,35,40,30,5,19)),100));
        System.out.println(a.twoSum(new ArrayList<>(Arrays.asList(50,20,35,35,40,30,5,19)),10));
    }

    public List<Integer> twoSum(List<Integer> nums, int tructSpace) {
        int target=tructSpace-30;
        Collections.sort(nums);
        int l=0,r=nums.size()-1;
        while (l<r){
            int s=nums.get(l)+nums.get(r);
            if (s==target)
                return new ArrayList<>(Arrays.asList(nums.get(l),nums.get(r)));
            else if (s<target)
                l+=1;
            else
                r-=1;
        }
        return new ArrayList<>();

    }
}