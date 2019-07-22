package Tree;
import Tree.structure.TreeNode;
import java.util.*;

public class Q94_BinaryTreeInorderTraversal {


    public static void main(String[] args){
        Q94_BinaryTreeInorderTraversal a = new Q94_BinaryTreeInorderTraversal();
        System.out.println(a.inorderTraversal(
                TreeNode.createTestData("[1,null,2,3,4,6]")
        ));
    }

//    Solution 1 recursive
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> ans=new ArrayList<>();
//        dfs(root,ans);
//        return ans;
//    }
//
//    private void dfs(TreeNode root,List<Integer> ans){
//        if (root!=null){
//            dfs(root.left,ans);
//            ans.add(root.val);
//            dfs(root.right,ans);
//        }
//    }

//    Solution 2 iterative
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans =new ArrayList<>();
        Stack<TreeNode> stack =new Stack<>();
        while (true){
            while (root!=null){
                stack.add(root);
                root=root.left;
            }
            if (stack.isEmpty()){
                break;
            }
            TreeNode node=stack.pop();
            ans.add(node.val);
            root=node.right;
        }
        return ans;
    }

}
