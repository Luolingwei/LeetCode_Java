package Tree;
import Tree.structure.TreeNode;
import java.util.*;

public class Q144_BinaryTreePreorderTraversal {

    public static void main(String[] args){
        Q144_BinaryTreePreorderTraversal a = new Q144_BinaryTreePreorderTraversal();
        System.out.println(a.preorderTraversal(
                TreeNode.createTestData("[1,null,2,3]")
        ));
    }

//    recursive

//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res=new ArrayList<>();
//        dfs(root,res);
//        return res;
//    }
//
//    public void dfs(TreeNode root,List<Integer> res) {
//        if (root!=null){
//            res.add(root.val);
//            dfs(root.left,res);
//            dfs(root.right,res);
//        }
//    }


//    iterative
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> res=new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            if (node!=null){
                res.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return res;
    }
}
