package Math;

import java.util.Arrays;

public class QAmazon_FourInteger {

    public static void main(String[] args){
        QAmazon_FourInteger a=new QAmazon_FourInteger();
        System.out.println(Arrays.toString(a.arrange(1,4,7,2)));
        System.out.println(Arrays.toString(a.arrange(1,9,7,2)));
        System.out.println(Arrays.toString(a.arrange(4,1,3,2)));
    }

    // 最大和最小的放两边，中间的两个根据大小放两边
    public int [] arrange(int A, int B, int C, int D){
        int [] nums=new int[] {A,B,C,D};
        Arrays.sort(nums);
        swap(0,1,nums);
        swap(2,3,nums);
        swap(0,3,nums);
        return nums;
    }

    public void swap(int i,int j, int [] A){
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }
}
