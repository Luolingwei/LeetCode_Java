package DynamicProgramming;
import java.util.*;

public class QAmazon_ArithmeticSequence {

    public static void main(String[] args){
        QAmazon_ArithmeticSequence a=new QAmazon_ArithmeticSequence();
        System.out.println(a.numberOfArithmeticSlices(new int []{1,2,3,4}));
        System.out.println(a.numberOfArithmeticSlices(new int []{1,2,3,4,5,6}));
    }

    public int numberOfArithmeticSlices(int[] A) {
        int carry=0,count=0;
        for (int i=2;i<A.length;i++){
            if (A[i]-A[i-1]==A[i-1]-A[i-2]){
                carry+=1;
                count+=carry;
            }
            else
                carry=0;
        }
        return count;
    }
}