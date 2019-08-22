package Greedy;

import java.util.*;

public class Q986_IntervalListIntersections {

    public static void main(String[] args){
        Q986_IntervalListIntersections a=new Q986_IntervalListIntersections();
        System.out.println(Arrays.deepToString(a.intervalIntersection(new int[][]{{0,2},{5,10},{13,23},{24,25}},new int[][]{{1,5},{8,12},{15,24},{25,26}})));
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i=0,j=0,tail=-1;
        List<int[]> C=new ArrayList<>();
        List<int[]> res=new ArrayList<>();
        while (i<A.length && j<B.length){
            if (A[i][0]<B[j][0]) {
                C.add(A[i]); i++;
            }
            else{
                C.add(B[j]);j++;
            }
        }
        while (i<A.length){
            C.add(A[i]); i++;
        }
        while (j<B.length) {
            C.add(B[j]);j++;
        }

        for (int[] interval: C){
            if (interval[0]<=tail) {
                res.add(new int[]{interval[0], Math.min(interval[1], tail)});
                tail = Math.max(tail, interval[1]);
            }
            else
                tail=interval[1];
        }
        return res.toArray(new int [res.size()][]);

    }
}
