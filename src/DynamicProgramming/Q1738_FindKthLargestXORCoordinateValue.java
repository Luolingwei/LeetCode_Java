package DynamicProgramming;

import java.util.PriorityQueue;
import java.util.Queue;

public class Q1738_FindKthLargestXORCoordinateValue {


    public static void main(String[] args) {
        System.out.println(kthLargestValue(new int[][]{{5,2},{1,6}},1));
        System.out.println(kthLargestValue(new int[][]{{5,2},{1,6}},2));
        System.out.println(kthLargestValue(new int[][]{{5,2},{1,6}},3));
        System.out.println(kthLargestValue(new int[][]{{5,2},{1,6}},4));
    }

    public static int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        Queue<Integer> q = new PriorityQueue<>();
        for (int i=0;i<m;i++) {
            for (int j=0;j<n; j++){
                if (i>0 && j>0) matrix[i][j] ^= matrix[i-1][j-1];
                if (i>0) matrix[i][j] ^= matrix[i-1][j];
                if (j>0) matrix[i][j] ^= matrix[i][j-1];
                q.add(matrix[i][j]);
                if (q.size()>k) q.poll();
            }
        }
        return q.poll();
    }
}
