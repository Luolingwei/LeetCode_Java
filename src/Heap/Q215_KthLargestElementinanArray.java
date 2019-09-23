package Heap;

import java.util.*;

public class Q215_KthLargestElementinanArray {

    public static void main(String[] args){
        Q215_KthLargestElementinanArray a=new Q215_KthLargestElementinanArray();
        System.out.println(a.findKthLargest(new int []{1,3,-1,-3,5,3,6,7},3));
        System.out.println(a.findKthLargest(new int []{1,3,1,2,0,5},3));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for (int n:nums){
            pq.add(n);
            if (pq.size()>k)
                pq.poll();
        }
        return pq.peek();
    }

}
