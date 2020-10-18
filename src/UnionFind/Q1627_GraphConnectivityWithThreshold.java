package UnionFind;

import java.util.*;

public class Q1627_GraphConnectivityWithThreshold {


    public static void main(String[] args) {
        Q1627_GraphConnectivityWithThreshold a = new Q1627_GraphConnectivityWithThreshold();
        System.out.println(a.areConnected(6, 2, new int[][]{{1,4},{2,5},{3,6}}));
        System.out.println(a.areConnected(6, 0, new int[][]{{4,5},{3,4},{3,2},{2,6},{1,3}}));
        System.out.println(a.areConnected(5, 1, new int[][]{{4,5},{4,5},{3,2},{2,3},{3,4}}));
    }

    private Map<Integer, Integer> uf = new HashMap<>();

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {

        if (threshold==0) return Collections.nCopies(queries.length, true);
        List<Boolean> res = new ArrayList<>();
        for (int i=1; i<=n; i++)
            for (int j=2*i; j<=n; j+=i)
                if (i>threshold) {
                    union(i,j);
                }
        for (int[] query: queries)
            res.add(find(query[0])==find(query[1]));
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
