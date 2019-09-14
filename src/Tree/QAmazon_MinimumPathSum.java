package Tree;

import Tree.structure.TreeNode;

public class QAmazon_MinimumPathSum {
    public static void main(String[] args){
        QAmazon_MinimumPathSum a = new QAmazon_MinimumPathSum();
        System.out.println((a.MinimumPathSum(
                TreeNode.createTestData("[5,8,9,12,2,8,4,null,null,null,null,2,null,5,null]")
        )));
    }

    int res=Integer.MAX_VALUE;
    public int MinimumPathSum(TreeNode root){
        dfs(root,0);
        return res;
    }

    public void dfs(TreeNode node, int curS){
        if (node!=null){
            if (node.left==null && node.right==null)
                res=Math.min(res,curS+node.val);
            else {
                dfs(node.left,curS+node.val);
                dfs(node.right,curS+node.val);
            }
        }
    }

}