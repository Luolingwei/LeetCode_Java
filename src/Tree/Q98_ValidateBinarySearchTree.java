package Tree;
import Tree.structure.TreeNode;
import java.util.*;

public class Q98_ValidateBinarySearchTree {
    public static void main(String[] args){
        Q98_ValidateBinarySearchTree a = new Q98_ValidateBinarySearchTree();
        System.out.println(a.isValidBST(
                TreeNode.createTestData("[2,1,3]")
        ));
    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root,null,null);
    }

    public boolean dfs(TreeNode node, Integer curmin, Integer curmax){
        if (node==null)
            return true;
        if (curmin!=null && node.val<=curmin || curmax!=null && node.val>=curmax)
            return false;
        return dfs(node.left, curmin, node.val) && dfs(node.right, node.val, curmax);
    }

}
