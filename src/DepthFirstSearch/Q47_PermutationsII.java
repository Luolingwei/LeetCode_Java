package DepthFirstSearch;
import java.util.*;

public class Q47_PermutationsII {

    public static void main(String[] args){
        Q47_PermutationsII a=new Q47_PermutationsII();
        System.out.println(a.permuteUnique(new int[]{1,1,2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        int N=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        boolean [] used=new boolean [N];
        LinkedList<Integer> path=new LinkedList<>();
        dfs(nums,path,res,used,0);
        return res;
    }

    public void dfs(int [] nums, LinkedList<Integer> path,List<List<Integer>> res, boolean [] used, int added) {
        int N=nums.length;
        if (added==N){
            res.add(new ArrayList<>(path));
        }
        for (int i=0;i<nums.length;i++){
            if (i>0 && !used[i-1] && nums[i]==nums[i-1])
                continue;
            if (!used[i]){
                used[i]=true;
                path.push(nums[i]);
                dfs(nums,path,res,used,added+1);
                used[i]=false;
                path.pop();
            }
        }
    }

}
