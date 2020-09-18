package UnionFind;

import java.util.*;

public class Q1584_MinCostToConnectAllPoints {

    public static void main(String[] args) {
        Q1584_MinCostToConnectAllPoints a = new Q1584_MinCostToConnectAllPoints();
        System.out.println(a.minCostConnectPoints_Kruskal(new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}}));
        System.out.println(a.minCostConnectPoints_Prim(new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}}));
    }

    // ==================== Kruskal ======================//
    // 1478 ms
    private Map<Integer, Integer> uf = new HashMap<>();

    public int find (int x) {
        while (uf.containsKey(x)) {
            while (uf.containsKey(uf.get(x)))
                uf.put(x,uf.get(uf.get(x)));
            x = uf.get(x);
        }
        return x;
    }

    public boolean union (int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return false;
        uf.put(px,py);
        return true;
    }


    public int minCostConnectPoints_Kruskal(int[][] points) {
        int n = points.length, res = 0;
        List<int[]> edges = new ArrayList<>();

        for (int i=0; i<n; i++){
            for (int j=i+1; j<n; j++){
                edges.add(new int[]{Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]), i, j});
            }
        }

        Collections.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        for (int[] edge: edges){
            int cost = edge[0], i = edge[1], j = edge[2];
            if (union(i,j)) res += cost;
        }
        return res;
    }

    // ==================== Prim ======================//
    // 120ms O(n^2)
    public int minCostConnectPoints_Prim(int[][] points) {
        int n = points.length, res = 0;
        int[] dist = new int[n], curp = points[0];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Set<Integer> T = new HashSet<>(Arrays.asList(0));

        for (int i=0; i<n-1; i++){
            for (int j=0; j<n; j++)
                if (!T.contains(j))
                    dist[j] = Math.min(dist[j], Math.abs(curp[0]-points[j][0])+Math.abs(curp[1]-points[j][1]));

            int minidx = findMinDist(dist);
            res += dist[minidx];
            T.add(minidx);
            curp = points[minidx];
            dist[minidx] = Integer.MAX_VALUE;
        }
        return res;
    }

    public int findMinDist(int[] dist){
        int res = 0, mindist = dist[0];
        for (int i=0; i<dist.length; i++)
            if (dist[i]<mindist){
                mindist = dist[i];
                res = i;
            }
        return res;
    }


}
