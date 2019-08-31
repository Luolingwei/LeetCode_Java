package Tree;

import Tree.structure.TreeNode;

public class Q965_UnivaluedBinaryTree {
    public static void main(String[] args){
        Q965_UnivaluedBinaryTree a = new Q965_UnivaluedBinaryTree();
        System.out.println((a.isUnivalTree(
                TreeNode.createTestData("[1,1,1,1,1,null,1")
        )));
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root==null)
            return true;
        return dfs(root,root.val);
    }

    public boolean dfs(TreeNode node, int n){
        if (node==null)
                return true;
        return node.val==n && dfs(node.left,n) && dfs(node.right,n);
    }

}
