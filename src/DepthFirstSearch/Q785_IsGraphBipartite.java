package DepthFirstSearch;

import java.util.*;

public class Q785_IsGraphBipartite {

    public static void main(String[] args){
        Q785_IsGraphBipartite a=new Q785_IsGraphBipartite();
        System.out.println(a.isBipartite(new int[][]{{1,3},{0,2},{1,3},{0,2}}));
        System.out.println(a.isBipartite(new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}}));
        System.out.println(a.isBipartite(new int[][]{{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}}));
    }

    public boolean isBipartite(int[][] graph) {
        int N=graph.length;
        Map<Integer,Integer> dic=new HashMap<>();
        for (int i=0;i<N;i++){
            if (!dic.containsKey(i))
                if (!dfs(dic,graph,i,1))
                    return false;
        }
        return true;

    }

    public boolean dfs( Map<Integer,Integer> dic, int[][] graph, int i, int color){

        if (dic.containsKey(i)) {
            return dic.get(i)==color;
        }
        else{
            dic.put(i,color);
            for (int j:graph[i]){
                if (!dfs(dic,graph,j,-color))
                    return false;
            }
        }
        return true;
    }
}