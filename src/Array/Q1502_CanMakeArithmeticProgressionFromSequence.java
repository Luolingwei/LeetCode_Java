package Array;

import java.util.HashSet;
import java.util.Set;

public class Q1502_CanMakeArithmeticProgressionFromSequence {

    public static void main(String[] args) {
        System.out.println(canMakeArithmeticProgression(new int[]{3,5,1}));
        System.out.println(canMakeArithmeticProgression(new int[]{1,2,4}));
        System.out.println(canMakeArithmeticProgression(new int[]{0,0,0}));
    }

    public static boolean canMakeArithmeticProgression(int[] arr) {
        int maxN = Integer.MIN_VALUE, minN = Integer.MAX_VALUE;
        for (int n: arr){
            if (n<minN) minN = n;
            if (n>maxN) maxN = n;
        }
        if ((maxN-minN)%(arr.length-1)!=0) return false;
        int gap = (maxN-minN)/(arr.length-1);
        if (gap==0) return true;
        Set<Integer> diff = new HashSet<>();
        for (int n: arr){
            if ((n-minN)%gap!=0)
                return false;
            diff.add(n-minN);
        }
        return diff.size()==arr.length;
    }
}
