package BreadthFirstSearch;

import java.util.*;

public class Q1617_CountSubtreesWithMaxDistanceBetweenCities {

    public static void main(String[] args) {
        Q1617_CountSubtreesWithMaxDistanceBetweenCities a = new Q1617_CountSubtreesWithMaxDistanceBetweenCities();
        System.out.println(Arrays.toString(a.countSubgraphsForEachDiameter(4, new int[][]{{1, 2}, {2, 3}, {2, 4}})));
        System.out.println(Arrays.toString(a.countSubgraphsForEachDiameter(2, new int[][]{{1,2}})));
        System.out.println(Arrays.toString(a.countSubgraphsForEachDiameter(3, new int[][]{{1,2},{2,3}})));
    }

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        int[] res = new int[n-1];
        for (int mask = 1; mask < (1<<n); mask++) {
            List<Integer> cities = new ArrayList<>();
            for (int i=1; i<=n; i++)
                if ((1<<(i-1) & mask) !=0)
                    cities.add(i);
            int maxd = maxDist(cities, edges);
            if (maxd>0) res[maxd-1]++;
        }
        return res;
    }

    private int maxDist(List<Integer> cities, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge: edges) {
            int x = edge[0], y = edge[1];
            if (cities.contains(x) && cities.contains(y)) {
                if (!graph.containsKey(x)) graph.put(x, new ArrayList<>());
                graph.get(x).add(y);
                if (!graph.containsKey(y)) graph.put(y, new ArrayList<>());
                graph.get(y).add(x);
            }
        }

        int maxd = 0;
        for (int city: cities) {
            int[] temp = bfs(city, graph);
            int dist = temp[0], visitedN = temp[1];
            if (visitedN!=cities.size()) return 0;
            maxd = Math.max(maxd, dist);
        }
        return maxd;
    }

    private int[] bfs(int city, Map<Integer, List<Integer>> graph) {
        Queue<int[]> q = new LinkedList<>(Arrays.asList(new int[]{city, 0}));
        Set<Integer> visited = new HashSet<>(Arrays.asList(city));
        int dist = 0;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int c = temp[0], d = temp[1];
            dist = d;
            if (graph.containsKey(c))
                for (int nextc: graph.get(c))
                    if (!visited.contains(nextc)){
                        q.add(new int[]{nextc,d+1});
                        visited.add(nextc);
                    }
        }
        return new int[]{dist, visited.size()};
    }
}
