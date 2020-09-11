package UnionFind;

public class Q1579_RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {

    public static void main(String[] args) {
        Q1579_RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable a = new Q1579_RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable();
        System.out.println(a.maxNumEdgesToRemove(4, new int[][]{{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}}));
        System.out.println(a.maxNumEdgesToRemove(4, new int[][]{{3,1,2},{3,2,3},{1,1,4},{2,1,4}}));
        System.out.println(a.maxNumEdgesToRemove(4, new int[][]{{3,2,3},{1,1,2},{2,3,4}}));
    }

    private int[] uf;

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        uf = new int[n+1];
        for (int i=0; i<n+1; i++) uf[i] = i;

        int res = 0, s1 = 0, s2 = 0;
        for (int[] edge: edges){
            int m = edge[0], i = edge[1], j = edge[2];
            if (m == 3) {
                if (!union(i,j)) res ++;
                else {
                    s1++;
                    s2++;
                }
            }
        }

        int [] copy_uf = uf.clone();
        for (int[] edge: edges){
            int m = edge[0], i = edge[1], j = edge[2];
            if (m == 2) {
                if (!union(i,j)) res ++;
                else s2++;
            }
        }

        uf = copy_uf;
        for (int[] edge: edges){
            int m = edge[0], i = edge[1], j = edge[2];
            if (m == 1) {
                if (!union(i,j)) res ++;
                else s1++;
            }
        }

        if (s1==n-1 && s2==n-1) return res;
        else return -1;

    }


    public int find(int x) {
        while (x!=uf[x]) {
            while (uf[uf[x]]!=uf[x]) uf[x] = uf[uf[x]];
            x = uf[x];
        }
        return x;
    }

    public boolean union(int x, int y) {
        int px = find(x), py = find(y);
        if (px==py) return false;
        uf[px] = py;
        return true;
    }


}
