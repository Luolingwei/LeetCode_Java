package DynamicProgramming;

import java.util.*;

public class Q1191_KConcatenationMaximumSum {

    public static void main(String[] args){
        Q1191_KConcatenationMaximumSum a=new Q1191_KConcatenationMaximumSum();
        System.out.println(a.kConcatenationMaxSum(new int []{1,2},3));
        System.out.println(a.kConcatenationMaxSum(new int []{1,-2,1},5));
        System.out.println(a.kConcatenationMaxSum(new int []{-1,-2},7));
    }

    public static int mod=1000000007;
    public int kConcatenationMaxSum(int[] arr, int k) {
        int T=0;
        for (int i=0;i<arr.length;i++)
            T+=arr[i];
        if (k==1) return helper(arr)%mod;
        long ans=(k-2)*(Math.max(0,T))+helper(construct2(arr));
        return (int) ans%mod;
    }

    public int helper(int [] nums){
        int maxS=nums[0],curS=nums[0];
        for (int i=1;i<nums.length;i++){
            curS=Math.max(curS+nums[i],nums[i]);
            maxS=Math.max(maxS,curS);
        }
        return Math.max(0,maxS);
    }

    public int [] construct2(int [] nums){
        int L=nums.length;
        int [] A=new int[L*2];
        for (int i=0;i<L;i++){
            A[i]=nums[i];
            A[i+L]=nums[i];
        }
        return A;
    }

}
