package DivideAndConquer;
import java.util.*;

public class Q215_KthLargestElementInArray {

    public static void main(String[] args){
        Q215_KthLargestElementInArray a = new Q215_KthLargestElementInArray();
        System.out.println(a.findKthLargest(new int[]{3,2,1,5,6,4},2));
        System.out.println(a.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }

    public int findKthLargest(int[] nums, int k) {
        return findKthSmallest(nums, nums.length+1-k);

    }

    public int findKthSmallest(int [] nums, int k){
        int pos=partition(nums);
        if (pos>k-1)
            return findKthSmallest(Arrays.copyOfRange(nums,0,pos),k);
        else if (pos<k-1)
            return findKthSmallest(Arrays.copyOfRange(nums,pos+1,nums.length),k-pos-1);
        else
            return nums[pos];
    }

    public int partition(int [] nums){
        int low=0,high=nums.length-1;
        int key=nums[0];
        while (low<high){
            while (low<high && (nums[high]>key || nums[high]==key))
                high-=1;
            while (low<high && (nums[low]<key || nums[low]==key))
                low+=1;
            swap(nums,low,high);
        }
        swap(nums,0,low);
        return low;
    }

    public void swap(int [] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
