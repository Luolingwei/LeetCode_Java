package DepthFirstSearch;

import java.util.ArrayList;
import java.util.*;

public class Q46_Permutations {
    public static void main(String[] args){
        Q46_Permutations a=new Q46_Permutations();
        System.out.println(a.permute(new int[]{1,2,3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        int N=nums.length;
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
