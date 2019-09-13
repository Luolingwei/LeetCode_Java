package SlidingWindow;

import java.util.*;

public class QAmazon_WindowSum2 {

    public static void main(String[] args){
        QAmazon_WindowSum2 a=new QAmazon_WindowSum2();
        System.out.println(Arrays.toString(a.GetSum(new int []{1,2,3,4,5,6,7},3)));
        System.out.println(Arrays.toString(a.GetSum(new int []{1,2,3,4,5,6,7},-1)));
        System.out.println(Arrays.toString(a.GetSum(new int [] {1,2,3,4,5,6,7},100)));
    }

    public int [] GetSum(int [] A, int k) {
        if (A==null|| A.length<k || k<=0)
            return null;
        int [] res=new int [A.length-k+1];
        for (int i=0;i<k;i++){
            res[0]+=A[i];
        }
        for (int i=1;i<res.length;i++){
            res[i]=res[i-1]+A[i+k-1]-A[i-1];
        }
        return res;
    }
}
