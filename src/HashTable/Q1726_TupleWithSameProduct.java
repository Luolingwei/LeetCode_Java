package HashTable;

import java.util.HashMap;
import java.util.Map;

public class Q1726_TupleWithSameProduct {

    public static void main(String[] args) {
        System.out.println(tupleSameProduct(new int[]{2,3,4,6}));
        System.out.println(tupleSameProduct(new int[]{1,2,4,5,10}));
        System.out.println(tupleSameProduct(new int[]{2,3,4,6,8,12}));
        System.out.println(tupleSameProduct(new int[]{2,3,5,7}));
    }

    public static int tupleSameProduct(int[] nums) {
        int L = nums.length, res = 0;
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i=0; i<L; i++){
            for (int j=i+1; j<L; j++) {
                int total = nums[i]*nums[j];
                int curPairs = memo.getOrDefault(total,0);
                res += 8*curPairs;
                memo.put(total,curPairs+1);
            }
        }
        return res;
    }

}
