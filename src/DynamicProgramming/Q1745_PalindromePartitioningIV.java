package DynamicProgramming;


public class Q1745_PalindromePartitioningIV {


    public static void main(String[] args) {
        System.out.println(checkPartitioning("abcbdd"));
        System.out.println(checkPartitioning("bcbddxy"));
    }

    public static boolean checkPartitioning(String s) {
        int L = s.length();
        boolean[][] memo = new boolean[L][L];
        for (int gap=0; gap<L; gap++) {
            for (int l=0; l<L-gap; l++) {
                int r = l + gap;
                if (gap<=1) {
                    memo[l][r] = s.charAt(l)==s.charAt(r);
                    continue;
                }
                if (s.charAt(l)==s.charAt(r)) memo[l][r] = memo[l+1][r-1];
                else memo[l][r] = false;
            }
        }

        for (int i=0; i<L; i++)
            for (int j=i+1; j<L-1; j++)
                if (memo[0][i] && memo[i+1][j] && memo[j+1][L-1]) return true;
        return false;
    }
}
