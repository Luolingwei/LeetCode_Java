package DynamicProgramming;

public class Q221_MaximalSquare {

    public static void main(String[] args) {
        System.out.println(maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
    }


    public static int maximalSquare(char[][] matrix) {
        if (matrix.length==0) return 0;
        int res = 0;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]=='1'){
                    memo[i][j] = 1;
                    if (i>0 && j>0) {
                        memo[i][j] = Math.min(memo[i-1][j-1],Math.min(memo[i-1][j],memo[i][j-1]))+1;
                    }
                    res = Math.max(res,memo[i][j]);
                } else {
                    memo[i][j] = 0;
                }
            }
        }
        return res*res;
    }
}
