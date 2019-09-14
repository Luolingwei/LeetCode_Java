package Tree;
import java.util.*;
import Tree.structure.TreeNode;

public class Q113_PathSumII {

    public static void main(String[] args){
        Q113_PathSumII a = new Q113_PathSumII();
        System.out.println((a.pathSum(
                TreeNode.createTestData("[5,4,8,11,null,13,4,7,2,null,null,null,null,5,1]"),22
        )));
    }

    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> path=new ArrayList<>();
        dfs(root,0,sum,path);
        return res;
    }

    public void dfs(TreeNode node,int curS,int sum, List<Integer> path){
        if (node!=null){
            path.add(node.val);
            if (node.left==null && node.right==null && curS+node.val==sum)
                res.add(path);
            dfs(node.left,curS+node.val,sum,new ArrayList<>(path));
            dfs(node.right,curS+node.val,sum,new ArrayList<>(path));
        }
    }
}