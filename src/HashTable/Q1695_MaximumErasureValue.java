package HashTable;

import java.util.HashSet;
import java.util.Set;

public class Q1695_MaximumErasureValue {

    public static void main(String[] args) {
        System.out.println(maximumUniqueSubarray(new int[]{4,2,4,5,6}));
        System.out.println(maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));
    }

    public static int maximumUniqueSubarray(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        int curS = 0, l = 0, res = 0;
        for (int n: nums) {
            while (visited.contains(n)) {
                visited.remove(nums[l]);
                curS-=nums[l];
                l++;
            }
            curS += n;
            visited.add(n);
            res = Math.max(res, curS);
        }
        return res;
    }
}
