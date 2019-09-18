package Array;
import java.util.*;

public class QAmazon_DayChange {
    public static void main(String[] args){
        QAmazon_DayChange a=new QAmazon_DayChange();
        System.out.println(Arrays.toString(a.change(new int []{0,1,1,0},1)));
        System.out.println(Arrays.toString(a.change(new int []{0,1,1,0},2)));
    }

    public int [] change(int [] array,int D){
        int [] newArray=new int[array.length+2];
        newArray[0]=newArray[newArray.length-1]=0;
        for (int i=1;i<newArray.length-1;i++) newArray[i]=array[i-1];
        for (int i=0;i<D;i++) cal(newArray);
        return Arrays.copyOfRange(newArray,1,newArray.length-1);
    }

    public void cal(int [] array){
        int pre=array[0];
        for (int i=1;i<array.length-1;i++){
            int temp=array[i];
            array[i]=pre^array[i+1];
            pre=temp;
        }
    }
}