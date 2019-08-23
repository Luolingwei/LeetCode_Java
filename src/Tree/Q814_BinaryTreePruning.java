package Tree;

import Tree.structure.TreeNode;

public class Q814_BinaryTreePruning {

    public static void main(String[] args){
        Q814_BinaryTreePruning a = new Q814_BinaryTreePruning();
        TreeNode.print(a.pruneTree(
                TreeNode.createTestData("[1,1,0,1,1,0,1,0]")
        ));
    }

    public TreeNode pruneTree(TreeNode root) {

        return dfs(root);

    }

    public TreeNode dfs(TreeNode root) {
        if (root==null) return null;
        root.left=dfs(root.left);
        root.right=dfs(root.right);
        if (root.left==null && root.right==null && root.val==0)
            return null;
        return root;

    }

}
