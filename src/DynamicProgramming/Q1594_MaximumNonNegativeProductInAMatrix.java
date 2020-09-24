package DynamicProgramming;

public class Q1594_MaximumNonNegativeProductInAMatrix {

    public static void main(String[] args) {
        System.out.println(maxProductPath(new int[][]{{1,4,4,0},{-2,0,0,1},{1,-1,1,1}}));
    }

    public static int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length, mod = 1_000_000_007;;
        long[][] mx = new long[m][n], mn = new long[m][n];
        mx[0][0] = mn[0][0] = grid[0][0];
        for (int i=1; i<m; i++) mx[i][0] = mn[i][0] = mx[i-1][0]*grid[i][0];
        for (int j=1; j<n; j++) mx[0][j] = mn[0][j] = mx[0][j-1]*grid[0][j];

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if (grid[i][j] > 0) {
                    mx[i][j] = Math.max(mx[i-1][j], mx[i][j-1])*grid[i][j];
                    mn[i][j] = Math.min(mn[i-1][j], mn[i][j-1])*grid[i][j];
                } else {
                    mx[i][j] = Math.min(mn[i-1][j], mn[i][j-1])*grid[i][j];
                    mn[i][j] = Math.max(mx[i-1][j], mx[i][j-1])*grid[i][j];
                }
            }
        }

        return mx[m-1][n-1]>=0? (int) (mx[m-1][n-1]%mod):-1;
    }

}
