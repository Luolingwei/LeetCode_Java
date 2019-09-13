package SlidingWindow;

import java.util.*;

public class QAmazon_WindowSum {

    public static void main(String[] args){
        QAmazon_WindowSum a=new QAmazon_WindowSum();
        System.out.println(a.GetSum(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7)),3));
        System.out.println(a.GetSum(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7)),-1));
        System.out.println(a.GetSum(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7)),100));
    }

    public List<Integer> GetSum(List<Integer> A, int k) {
        List<Integer> res=new ArrayList<>();
        if (A.isEmpty() || A.size()<k || k<=0)
            return res;
        int curS=0,i=0;
        for (;i<k;i++){
            curS+=A.get(i);
        }
        res.add(curS);
        while (i<A.size()){
            curS+=A.get(i);
            curS-=A.get(i-k);
            res.add(curS);
            i+=1;
        }
        return res;
        }
    }