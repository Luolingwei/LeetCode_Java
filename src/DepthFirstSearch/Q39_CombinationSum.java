package DepthFirstSearch;
import java.util.*;

public class Q39_CombinationSum {

    public static void main(String[] args){
        Q39_CombinationSum a=new Q39_CombinationSum();
        System.out.println(a.combinationSum(new int[]{2,3,6,7},7));
    }

    List<List<Integer>> ans= new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates,new ArrayList<Integer>(),0,target);
        return ans;
    }

    public void dfs(int[] candidates,List<Integer> path, int start, int target){
        if (target<=0) {
            if (target == 0)
                ans.add(new ArrayList<>(path));
            return;
        }
        for (int i=start;i<candidates.length;i++){
            path.add(candidates[i]);
            dfs(candidates,path,i,target-candidates[i]);
            path.remove(path.size()-1);
        }

    }
}
