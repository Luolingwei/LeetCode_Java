package Array;

public class Q1582_SpecialPositionsInABinaryMatrix {

    public static void main(String[] args) {
        System.out.println(numSpecial(new int[][]{{1,0,0},{0,0,1},{1,0,0}}));
        System.out.println(numSpecial(new int[][]{{1,0,0},{0,1,0},{0,0,1}}));
    }

    public static int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length, res = 0;
        int[] rowS = new int[m], colS = new int[n];

        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                if (mat[i][j]==1){
                    rowS[i]++;
                    colS[j]++;
                }

        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                if (mat[i][j]==1 & rowS[i]==1 & colS[j]==1) res++;

        return res;

    }

}
