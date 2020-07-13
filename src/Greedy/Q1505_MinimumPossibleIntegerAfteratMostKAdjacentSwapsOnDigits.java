package Greedy;

import java.util.Arrays;

public class Q1505_MinimumPossibleIntegerAfteratMostKAdjacentSwapsOnDigits {


    public static void main(String[] args) {
        System.out.println(minInteger("4321",4));
        System.out.println(minInteger("100",1));
    }

    public static String minInteger(String num, int k) {
        if (k==0) return num;
        if (k>=(num.length()*(num.length()-1))){
            char[] chars = num.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
        for (int d=0;d<10;d++){
            int idx = num.indexOf(d+"");
            if (idx>=0 && idx<=k){
                return num.charAt(idx) + minInteger(num.substring(0,idx)+num.substring(idx+1),k-idx);
            }
        }
        return "";
    }
}
