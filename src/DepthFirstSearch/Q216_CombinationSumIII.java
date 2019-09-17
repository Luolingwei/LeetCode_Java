package DepthFirstSearch;
import java.util.*;

public class Q216_CombinationSumIII {

    public static void main(String[] args){
        Q216_CombinationSumIII a=new Q216_CombinationSumIII();
        System.out.println(a.combinationSum3(3,7));
        System.out.println(a.combinationSum3(3,9));
    }
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(new ArrayList<>(),1,k,n);
        return ans;
    }

    public void dfs(List<Integer> path, int start, int count, int target){
        if (target<=0 || count<=0){
            if (target==0 && count==0)
                ans.add(new ArrayList<>(path));
            else
                return;
        }
        for (int i=start;i<=9;i++){
            path.add(i);
            dfs(path,i+1,count-1,target-i);
            path.remove(path.size()-1);
        }
    }
}
