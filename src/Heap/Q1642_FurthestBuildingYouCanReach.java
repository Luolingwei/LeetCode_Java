package Heap;

import java.util.PriorityQueue;

public class Q1642_FurthestBuildingYouCanReach {

    public static void main(String[] args) {
        System.out.println(furthestBuilding(new int[]{4,2,7,6,9,14,12}, 5, 1));
        System.out.println(furthestBuilding(new int[]{4,12,2,7,3,18,20,3,19}, 10 ,2));
        System.out.println(furthestBuilding(new int[]{14,3,19,3}, 17, 0));
    }

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        int pos = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        while (pos<heights.length-1){
            int cost = heights[pos+1] - heights[pos];
            if (cost>0){
                bricks -= cost;
                q.add(-cost);
                while (bricks<0){
                    ladders --;
                    if (ladders<0) return pos;
                    bricks -= q.poll();
                }
            }
            pos++;
        }
        return pos;
    }
}
