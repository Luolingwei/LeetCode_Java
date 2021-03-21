package BreadthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1765_MapOfHighestPeak {

    public static void main(String[] args) {
        Q1765_MapOfHighestPeak a = new Q1765_MapOfHighestPeak();
        System.out.println(Arrays.deepToString(a.highestPeak(new int[][]{{0,1},{0,0}})));
        System.out.println(Arrays.deepToString(a.highestPeak(new int[][]{{0,0,1},{1,0,0},{0,0,0}})));

    }

    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length, dist = 1;
        int[][] res = new int[m][n];
        List<int[]> q = new ArrayList<>();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (isWater[i][j]==1){
                    q.add(new int[]{i,j});
                    res[i][j]=0;
                } else {
                    res[i][j]=-1;
                }
            }
        }

        while (!q.isEmpty()) {
            List<int[]> newq = new ArrayList<>();
            for (int[] point: q) {
                int x = point[0], y = point[1];
                for (int[] dir: new int[][]{{0,1},{0,-1},{1,0},{-1,0}}) {
                    int newx = x+dir[0], newy = y+dir[1];
                    if (newx>=0 && newx<m && newy>=0 && newy<n && res[newx][newy]==-1) {
                        res[newx][newy] = dist;
                        newq.add(new int[]{newx,newy});
                    }
                }
            }
            q = newq;
            dist++;
        }
        return res;
    }
}
