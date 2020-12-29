package Array;

import java.util.Arrays;

public class Q1706_WhereWillTheBallFall {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findBall(new int[][]{{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}})));
        System.out.println(Arrays.toString(findBall(new int[][]{{1}})));
        System.out.println(Arrays.toString(findBall(new int[][]{{-1}})));
    }

    public static int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        for (int i=0; i<n; i++) {
            int y = 0, x = i;
            while (y<m) {
                int delta = grid[y][x];
                if (x+delta<0 || x+delta>=n) break;
                if (grid[y][x]==grid[y][x+delta]) {
                    x += grid[y][x];
                    y++;
                } else
                    break;
            }
            if (y==m) res[i]=x;
        }
        return res;
    }
}
