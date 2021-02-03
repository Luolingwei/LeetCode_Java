package Greedy;

import java.util.*;

public class Q1743_RestoreTheArrayFromAdjacentPairs {


    public static void main(String[] args) {
        Q1743_RestoreTheArrayFromAdjacentPairs a = new Q1743_RestoreTheArrayFromAdjacentPairs();
        System.out.println(Arrays.toString(a.restoreArray(new int[][]{{2,1},{3,4},{3,2}})));
        System.out.println(Arrays.toString(a.restoreArray(new int[][]{{4,-2},{1,4},{-3,1}})));
        System.out.println(Arrays.toString(a.restoreArray(new int[][]{{100000,-100000}})));

    }

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> memo = new HashMap<>();
        int start = 0, N = adjacentPairs.length+1;
        for (int[] pair: adjacentPairs) {
            int x = pair[0], y = pair[1];
            memo.computeIfAbsent(x, a->new ArrayList<>()).add(y);
            memo.computeIfAbsent(y, a->new ArrayList<>()).add(x);
        }

        for (Map.Entry<Integer, List<Integer>> e: memo.entrySet()) {
            if (e.getValue().size()==1) {
                start = e.getKey();
                break;
            }
        }

        int[] res = new int[N];
        res[0] = start;
        int idx = 1;
        Set<Integer> visited = new HashSet<>(Arrays.asList(start));

        while (idx<N) {
            for (int nextNode: memo.get(start)) {
                if (!visited.contains(nextNode)) {
                    start = nextNode;
                    visited.add(nextNode);
                    res[idx++] = nextNode;
                }
            }
        }
        return res;
    }
}
