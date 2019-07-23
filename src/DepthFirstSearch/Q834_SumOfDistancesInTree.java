package DepthFirstSearch;

import java.util.*;

public class Q834_SumOfDistancesInTree {

    public static void main(String[] args){
        Q834_SumOfDistancesInTree a=new Q834_SumOfDistancesInTree();
        System.out.println(Arrays.toString(a.sumOfDistancesInTree(6,new int [][]{{0,1},{0,2},{2,3},{2,4},{2,5}})));
    }


    List<HashSet<Integer>> tree;
    int [] dist;
    int [] count;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        tree=new ArrayList<>();
        dist=new int[N];
        count=new int[N];
        for (int i=0; i<N; i++)
            tree.add(new HashSet<Integer>());
        for (int [] edge: edges){
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        dfs_0(0,-1);
        dfs_other(0,-1);
        return dist;

    }

    public void dfs_0(int root, int pre){
        for (int node: tree.get(root)){
            if (node!=pre){
                dfs_0(node,root);
                count[root]+=count[node];
                dist[root]+=dist[node]+count[node];
            }
        }
        count[root]+=1;
    }

    public void dfs_other(int root,int pre){
        for (int node:tree.get(root)){
            if (node!=pre){
                dist[node]=dist[root]-count[node]+count.length-count[node];
                dfs_other(node,root);
            }
        }
    }


}
