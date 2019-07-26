package DynamicProgramming;


import java.util.*;

public class Q960_DeleteColumnsToMakeSortedIII {

    public static void main(String[] args){
        Q960_DeleteColumnsToMakeSortedIII a=new Q960_DeleteColumnsToMakeSortedIII();
        System.out.println(a.minDeletionSize(new String[] {"babca","bbazb"}));
        System.out.println(a.minDeletionSize(new String[] {"edcba"}));
        System.out.println(a.minDeletionSize(new String[] {"ghi","def","abc"}));
    }

    public int minDeletionSize(String[] A) {
        int N=A[0].length(),m=A.length,max_l=0,k;
        int [] dp=new int [N];
        Arrays.fill(dp,1);

        for (int i=1;i<N;i++){
            for (int j=0;j<i;j++){
                for (k=0;k<m;k++){
                    if (A[k].charAt(j)>A[k].charAt(i))
                            break;
                }
                if (k==m)
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
            max_l=Math.max(max_l,dp[i]);
        }
        return N-max_l;

    }

}
