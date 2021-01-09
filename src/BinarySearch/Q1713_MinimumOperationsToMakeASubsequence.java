package BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1713_MinimumOperationsToMakeASubsequence {

    public static void main(String[] args) {
        Q1713_MinimumOperationsToMakeASubsequence a = new Q1713_MinimumOperationsToMakeASubsequence();
        System.out.println(a.minOperations(new int[]{5,1,3}, new int[]{9,4,2,3,4}));
        System.out.println(a.minOperations(new int[]{6,4,8,1,3,2}, new int[]{4,7,6,2,3,8,6,1}));
    }

    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i=0; i<target.length; i++) memo.put(target[i],i);
        List<Integer> q = new ArrayList<>();

        for (int i=0; i<arr.length; i++) {
            if (memo.containsKey(arr[i])) {
                int pos = memo.get(arr[i]);
                int idx = search(q,pos);
                if (idx == q.size())
                    q.add(pos);
                else
                    q.set(idx,pos);
            }

        }
        return target.length-q.size();
    }

    public int search(List<Integer> q, int target) {

        int l = 0, r = q.size()-1;
        while (l<r) {
            int mid = (l+r)/2;
            if (q.get(mid)<target)
                l=mid+1;
            else
                r=mid;
        }
        if (l==q.size()-1 && q.get(q.size()-1)<target) return q.size();
        return l;
    }

}
