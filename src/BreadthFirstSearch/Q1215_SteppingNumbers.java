package BreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q1215_SteppingNumbers {

    public static void main(String[] args) {
        System.out.println(countSteppingNumbers(0,21));
    }

    public static List<Integer> countSteppingNumbers(int low, int high) {
        LinkedList<Long> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for (long i=1;i<10;i++) q.add(i);
        if (low==0) res.add(0);
        while (!q.isEmpty()){
            long n = q.poll();
            if (n>=low && n<=high)
                res.add((int) n);
            if (n<high){
                long digit = n%10;
                if (digit-1>=0) q.add(n*10+digit-1);
                if (digit+1<=9) q.add(n*10+digit+1);
            }
        }
        return res;
    }
}
