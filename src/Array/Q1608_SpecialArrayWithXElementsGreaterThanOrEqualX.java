package Array;

import java.util.HashMap;
import java.util.Map;

public class Q1608_SpecialArrayWithXElementsGreaterThanOrEqualX {

    public static void main(String[] args) {
        System.out.println(specialArray(new int[]{3,5}));
        System.out.println(specialArray(new int[]{0,0}));
        System.out.println(specialArray(new int[]{0,4,3,0,4}));
    }

    public static int specialArray(int[] nums) {

        Map<Integer,Integer> count = new HashMap<>();
        for (int n: nums)
            count.put(n,count.getOrDefault(n,0)+1);

        int total = nums.length;
        for (int i=0; i<=nums.length; i++) {
            if (total == i) return i;
            total -= count.getOrDefault(i,0);
        }

        return -1;
    }

}
