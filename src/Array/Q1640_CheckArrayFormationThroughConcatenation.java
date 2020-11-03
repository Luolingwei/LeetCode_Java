package Array;

import java.util.*;

public class Q1640_CheckArrayFormationThroughConcatenation {

    public static void main(String[] args) {
        Q1640_CheckArrayFormationThroughConcatenation a = new Q1640_CheckArrayFormationThroughConcatenation();
        System.out.println(a.canFormArray(new int[]{85}, new int[][]{{85}}));
        System.out.println(a.canFormArray(new int[]{49,18,16}, new int[][]{{16,18,49}}));
        System.out.println(a.canFormArray(new int[]{91,4,64,78}, new int[][]{{78},{4,64},{91}}));
    }

    public boolean canFormArray(int[] arr, int[][] pieces) {
        int[] res = new int[arr.length];
        Map<Integer, int[]> memo = new HashMap<>();
        int i = 0;
        for (int[] piece: pieces){
            memo.put(piece[0],piece);
        }
        for (int n: arr){
            if (memo.containsKey(n)){
                for (int addNum: memo.get(n))
                    res[i++] = addNum;
            }
        }
        return Arrays.equals(res, arr);
    }

}
