package UnionFind;

import java.util.HashMap;
import java.util.Map;

public class Q1722_MinimizeHammingDistanceAfterSwapOperations {


    public static void main(String[] args) {
        Q1722_MinimizeHammingDistanceAfterSwapOperations a = new Q1722_MinimizeHammingDistanceAfterSwapOperations();
        System.out.println(a.minimumHammingDistance(new int[]{1,2,3,4}, new int[]{2,1,4,5}, new int[][]{{0,1},{2,3}}));
        System.out.println(a.minimumHammingDistance(new int[]{1,2,3,4}, new int[]{1,3,2,4}, new int[][]{}));
        System.out.println(a.minimumHammingDistance(new int[]{5,1,2,4,3}, new int[]{1,5,4,2,3}, new int[][]{{0,4},{4,2},{1,3},{1,4}}));
    }

    Map<Integer, Integer> uf;

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {

        uf = new HashMap<>();
        int N = source.length;
        for (int[] pair: allowedSwaps) union(pair[0],pair[1]);

        Map<Integer, Map<Integer, Integer>> count = new HashMap<>();
        for (int i=0; i<N; i++) {
            int root = find(i);
            if (!count.containsKey(root)) count.put(root,new HashMap<>());
            Map<Integer, Integer> curMap = count.get(root);
            curMap.put(target[i], curMap.getOrDefault(target[i],0)+1);
        }

        int res = 0;
        for (int i=0; i<N; i++) {
            int root = find(i);
            Map<Integer, Integer> curMap = count.get(root);
            if (curMap.getOrDefault(source[i],0)>0)
                curMap.put(source[i], curMap.get(source[i])-1);
            else
                res++;
        }
        return res;
    }

    private int find(int x) {
        while (uf.containsKey(x)) {
            while (uf.containsKey(uf.get(x)))
                uf.put(x,uf.get(uf.get(x)));
            x = uf.get(x);
        }
        return x;
    }

    private boolean union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return false;
        uf.put(px,py);
        return true;
    }
}
