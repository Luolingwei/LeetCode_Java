package Array;
import java.util.*;

public class Q896_MonotonicArray {

    public static void main(String[] args){
        Q896_MonotonicArray a=new Q896_MonotonicArray();
        System.out.println(a.isMonotonic(new int []{2, 7, 11, 15}));
    }

    public boolean isMonotonic(int[] A) {
        boolean inc=true,dec=true;
        for (int i=0;i<A.length-1;i++){
            inc &=A[i]<=A[i+1];
            dec &=A[i]>=A[i+1];
            if (!inc&&!dec)
                return false;
        }
        return inc || dec;

    }
}
