package Heap;

import java.util.PriorityQueue;

public class Q1675_MinimizeDeviationInArray {


    public static void main(String[] args) {

        Q1675_MinimizeDeviationInArray a = new Q1675_MinimizeDeviationInArray();
        System.out.println(a.minimumDeviation(new int[]{1,2,3,4}));
        System.out.println(a.minimumDeviation(new int[]{4,1,5,20,3}));
        System.out.println(a.minimumDeviation(new int[]{2,10,8}));
        System.out.println(a.minimumDeviation(new int[]{3,5}));
        System.out.println(a.minimumDeviation(new int[]{10,4,3}));
    }


    public int minimumDeviation(int[] nums) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        int maxN = -1, res = Integer.MAX_VALUE;
        for (int n: nums) {
            int minOdd = getMinOdd(n);
            maxN = Math.max(maxN, minOdd);
            pq.add(new int[]{minOdd,n});
        }
        while (pq.size() == nums.length) {
            int[] pairA = pq.poll();
            int a = pairA[0], a0 = pairA[1];
            res = Math.min(res, maxN - a);
            if (a%2!=0 || a<a0) {
                maxN = Math.max(maxN, a*2);
                pq.add(new int[]{a*2, a0});
            }
        }
        return res;
    }

    private int getMinOdd(int n) {
        while ((n&1)==0){
            n>>=1;
        }
        return n;
    }

}
