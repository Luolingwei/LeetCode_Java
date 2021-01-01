package Heap;

import java.util.PriorityQueue;

public class Q1705_MaximumNumberOfEatenApples {


    public static void main(String[] args) {
        System.out.println(eatenApples(new int[]{1,2,3,5,2}, new int[]{3,2,1,4,2}));
        System.out.println(eatenApples(new int[]{3,0,0,0,0,2}, new int[]{3,0,0,0,0,2}));
    }


    public static int eatenApples(int[] apples, int[] days) {
        int i = 0, res = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        while (i<apples.length || !pq.isEmpty()) {
            if (i<apples.length && apples[i]>0) pq.add(new int[]{i+days[i], apples[i]});
            while (!pq.isEmpty() && (pq.peek()[0]<=i || pq.peek()[1]==0)) pq.poll();
            if (!pq.isEmpty()) {
                res ++;
                pq.peek()[1]--;
            }
            i++;
        }
        return res;
    }
}
