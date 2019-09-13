package Tree;
import java.util.*;

import Tree.structure.TreeNode;

public class Q508_MostFrequentSubtreeSum {
    public static void main(String[] args){

        Q508_MostFrequentSubtreeSum a = new Q508_MostFrequentSubtreeSum();
        System.out.println(Arrays.toString(a.findFrequentTreeSum(
                TreeNode.createTestData("[5,2,-5]")
        )));
    }

    Map<Integer,Integer> dic=new HashMap<>();
    int maxfreq=0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> res=new ArrayList<>();
        for (int key: dic.keySet()){
            if (dic.get(key)==maxfreq)
                res.add(key);

        }
        return res.stream().mapToInt(i->i).toArray();
    }
    public int dfs(TreeNode root){
        if (root==null)
            return 0;
        int curS=root.val+dfs(root.left)+dfs(root.right);
        dic.put(curS,dic.getOrDefault(curS,0)+1);
        maxfreq=Math.max(maxfreq,dic.get(curS));
        return curS;
    }

}
