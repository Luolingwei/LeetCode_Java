package DepthFirstSearch;
import java.util.*;

public class Q40_CombinationSumII {

    public static void main(String[] args){
        Q40_CombinationSumII a=new Q40_CombinationSumII();
        System.out.println(a.combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,new ArrayList<>(),target,0);
        return ans;
    }

    public void dfs(int[] candidates,List<Integer> path,int target, int start){
        if (target<=0){
            if (target==0)
                ans.add(path);
            return;
        }
        for (int i=start;i<candidates.length;i++){
            if (i>start && candidates[i]==candidates[i-1]) continue;
            List<Integer> p=new ArrayList<>(path);
            p.add(candidates[i]);
            dfs(candidates,p,target-candidates[i],i+1);
        }
    }
}