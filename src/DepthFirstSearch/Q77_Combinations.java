package DepthFirstSearch;
import java.util.*;

public class Q77_Combinations {
    public static void main(String[] args){
        Q77_Combinations a=new Q77_Combinations();
        System.out.println(a.combine(4,2));
    }

    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n <= 0) return new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        dfs(1, n, k, new ArrayList<Integer>(),res);
        return res;
    }

    public void dfs(int start,int n, int k,List<Integer> path,List<List<Integer>> res) {
        if (k==0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=start;i<=n;i++){
            path.add(i);
            dfs(i+1,n,k-1,path,res);
            path.remove(path.size()-1);
        }
    }
}
