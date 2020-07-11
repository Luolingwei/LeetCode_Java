package DynamicProgramming;

import java.util.Arrays;

public class Q1504_CountSubmatricesWithAllOnes {

    public static void main(String[] args) {
        Q1504_CountSubmatricesWithAllOnes a = new Q1504_CountSubmatricesWithAllOnes();
        System.out.println(a.numSubmat(new int[][]{{1,0,1},{1,1,0},{1,1,0}}));
    }

    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int res = 0;
        for (int i=0; i<m; i++){
            int[] memo = new int[n];
            Arrays.fill(memo,1);
            for (int j=i;j<m;j++){
                for (int k=0;k<n;k++) memo[k]&=mat[j][k];
                res += count1D(memo);
            }
        }
        return res;
    }

    private int count1D(int[] nums){
        int total=0, l=0;
        for (int n: nums){
            if (n==1) l++;
            else l=0;
            total += l;
        }
        return total;
    }
}
