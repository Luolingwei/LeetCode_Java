package Array;

import java.util.*;

public class QAmazon_OptimizeMemoryUsage {

    public static void main(String[] args){
        QAmazon_OptimizeMemoryUsage a=new QAmazon_OptimizeMemoryUsage();
        System.out.println(a.findcloest(new int []{1, 7, 2, 4, 5, 6},new int[] {3, 1, 2},6));
        System.out.println(a.findcloest(new int []{1, 7, 2, 4, 5, 6},new int[] {3, 1, 2},10));
    }

    public List<List<Integer>> findcloest(int [] A, int [] B, int K){
        Arrays.sort(A);
        Arrays.sort(B);
        List<List<Integer>> ans=new ArrayList<>();
        int minGap=Integer.MAX_VALUE;
        int l=0,r=B.length-1;
        while (l<A.length && r>=0){
            int s=A[l]+B[r];
            if (s>K)
                r-=1;
            else{
                if (K-s<=minGap){
                    if (K-s<minGap){
                        ans=new ArrayList<>();
                    }
                    ans.add(new ArrayList<>(Arrays.asList(A[l],B[r])));
                    minGap=K-s;
                }
                l+=1;
            }
        }
        return ans;
    }
}
