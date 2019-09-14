package Tree;

import Tree.structure.TreeNode;

public class QAmazon_TreeAmplitude {

    public static void main(String[] args){
        QAmazon_TreeAmplitude a = new QAmazon_TreeAmplitude();
        System.out.println((a.TreeAmplitude(
                TreeNode.createTestData("[5,8,9,12,2,8,4,null,null,null,null,2,null,5,null]")
        )));
    }

    int res=0;
    public int TreeAmplitude (TreeNode root){
        if (root==null) return 0;
        dfs(root,root.val,root.val);
        return res;
    }

    public void dfs(TreeNode root,int L, int S){
        if (root!=null){
            L=Math.max(L,root.val);
            S=Math.min(S,root.val);
            res=Math.max(res,L-S);
            dfs(root.left,L,S);
            dfs(root.right,L,S);
        }
    }
}