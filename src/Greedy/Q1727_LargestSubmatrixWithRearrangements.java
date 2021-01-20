package Greedy;

import java.util.Arrays;

public class Q1727_LargestSubmatrixWithRearrangements {


    public static void main(String[] args) {
        System.out.println(largestSubmatrix(new int[][]{{0,0,1},{1,1,1},{1,0,1}}));
        System.out.println(largestSubmatrix(new int[][]{{1,0,1,0,1}}));
        System.out.println(largestSubmatrix(new int[][]{{1,1,0},{1,0,1}}));
        System.out.println(largestSubmatrix(new int[][]{{0,0},{0,0}}));
    }


    public static int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, res = 0;
        int[][] memo = new int[m][n];
        for (int j=0; j<n; j++) {
            for (int i=0; i<m; i++){
                if (matrix[i][j]==1)
                    memo[i][j] = i!=0?memo[i-1][j]+1:1;
            }
        }
        for (int[] row: memo) Arrays.sort(row);
        for (int i=0; i<m; i++)
            for (int j=n-1; j>=0; j--) {
                int maxCL = memo[i][j];
                res = Math.max(res, (n-j)*maxCL);
            }
        return res;
    }

}
