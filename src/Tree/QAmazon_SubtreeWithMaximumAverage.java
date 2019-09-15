package Tree;

import Tree.structure.TreeNode;

public class QAmazon_SubtreeWithMaximumAverage {

    //限制前两个level的话加上level参数即可
    //在比较max时限制level==1 or 2

    public static void main(String[] args){
        QAmazon_SubtreeWithMaximumAverage a = new QAmazon_SubtreeWithMaximumAverage();
        TreeNode.print((a.find(
                TreeNode.createTestData("[1,-55,-110,1,2,4,-2]")
        )));
    }
    float res=Integer.MIN_VALUE;
    TreeNode MaxNode=null;
    public TreeNode find(TreeNode root){
        dfs(1,root);
        return MaxNode;
    }

    public float[] dfs(int level,TreeNode root){
        if (root==null)
            return new float[] {0,0};
        float [] l=dfs(level+1,root.left);
        float [] r=dfs(level+1,root.right);
        float curS=l[0]+r[0]+root.val,curN=l[1]+r[1]+1;
        if ((level==1 || level==2) && curS/curN>res){
            res=curS/curN;
            MaxNode=root;
        }
        return new float[]{curS,curN};
    }

}
