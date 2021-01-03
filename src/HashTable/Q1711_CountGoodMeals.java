package HashTable;

import java.util.HashMap;
import java.util.Map;

public class Q1711_CountGoodMeals {

    public static void main(String[] args) {
        System.out.println(countPairs(new int[]{1,3,5,7,9}));
        System.out.println(countPairs(new int[]{1,1,1,3,3,3,7}));
    }

    public static int countPairs(int[] deliciousness) {
        Map<Integer, Integer> memo = new HashMap<>();
        int res = 0, mod = 1000000007;
        for (int n: deliciousness) {
            int target = 1;
            for (int i=0; i<=21; i++) {
                res += memo.getOrDefault(target-n,0);
                res %= mod;
                target<<=1;
            }
            memo.put(n,memo.getOrDefault(n,0)+1);
        }
        return res%mod;
    }
}
