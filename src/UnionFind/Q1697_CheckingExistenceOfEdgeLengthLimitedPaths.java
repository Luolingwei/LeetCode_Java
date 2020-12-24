package UnionFind;

import java.util.*;

public class Q1697_CheckingExistenceOfEdgeLengthLimitedPaths {

    public static void main(String[] args) {

        Q1697_CheckingExistenceOfEdgeLengthLimitedPaths a = new Q1697_CheckingExistenceOfEdgeLengthLimitedPaths();
        System.out.println(Arrays.toString(a.distanceLimitedPathsExist(3, new int[][]{{0,1,2},{1,2,4},{2,0,8},{1,0,16}}, new int[][]{{0,1,2},{0,2,5}})));
        System.out.println(Arrays.toString(a.distanceLimitedPathsExist(5, new int[][]{{0,1,10},{1,2,5},{2,3,9},{3,4,13}}, new int[][]{{0,4,14},{1,4,13}})));
    }

    private Map<Integer, Integer> uf = new HashMap<>();

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {

        Arrays.sort(edgeList, (x,y)->x[2]-y[2]);
        List<Integer> idxSet = new ArrayList<>();
        for (int i=0; i<queries.length; i++) idxSet.add(i);
        Collections.sort(idxSet, (x,y)->queries[x][2]-queries[y][2]);
        boolean[] res = new boolean[queries.length];
        int i = 0;
        for (int idx: idxSet) {

            while (i<edgeList.length && edgeList[i][2]<queries[idx][2]) {
                union(edgeList[i][0], edgeList[i][1]);
                i++;
            }
            res[idx] = (find(queries[idx][0]) == find(queries[idx][1]));
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
