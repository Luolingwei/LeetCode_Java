package Heap;

import java.util.*;

public class Q1383_MaximumPerformanceofATeam {

    public static void main(String[] args){
        Q1383_MaximumPerformanceofATeam a=new Q1383_MaximumPerformanceofATeam();
        System.out.println(a.maxPerformance(6, new int[]{2,10,3,1,5,8}, new int[]{5,4,3,9,7,2},2));
    }

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<int[]> engineers = new ArrayList<>();
        for (int i=0;i<n;i++){
            engineers.add(new int[]{efficiency[i],speed[i]});
        }
        Collections.sort(engineers, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long totalS=0, res =0;
        for (int i=0;i<n;i++){
            pq.add(engineers.get(i)[1]);
            totalS+=engineers.get(i)[1];
            if (pq.size()>k) totalS-=pq.poll();
            res=Math.max(res,engineers.get(i)[0]*totalS);
        }
        return (int)(res%(long) (1e9+7));
    }

}
