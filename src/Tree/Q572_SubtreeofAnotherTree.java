package Tree;

import Tree.structure.TreeNode;

public class Q572_SubtreeofAnotherTree {
    public static void main(String[] args){
        Q572_SubtreeofAnotherTree a = new Q572_SubtreeofAnotherTree();
        System.out.println(a.isSubtree(
                TreeNode.createTestData("[3,4,5,1,2,null,null]"),
                TreeNode.createTestData("[4,1,2]")
        ));
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s==null)
            return false;
        return sametree(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    public boolean sametree(TreeNode a, TreeNode b){
        if (a==null || b==null)
            return a==b;
        if (a.val!=b.val)
            return false;
        return sametree(a.left,b.left) && sametree(a.right,b.right);
    }
}
