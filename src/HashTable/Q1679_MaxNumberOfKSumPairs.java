package HashTable;

import java.util.HashMap;
import java.util.Map;

public class Q1679_MaxNumberOfKSumPairs {

    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{1,2,3,4},5));
        System.out.println(maxOperations(new int[]{3,1,3,4,3},6));
    }


    public static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> memo = new HashMap<>();
        int res = 0;
        for (int n: nums) {
            int curleft = memo.getOrDefault(k-n,0);
            if (curleft>0) {
                memo.put(k-n,curleft-1);
                res ++;
            } else
                memo.put(n,memo.getOrDefault(n,0)+1);
        }
        return res;
    }
}
