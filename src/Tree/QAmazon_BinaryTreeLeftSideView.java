package Tree;

import Tree.structure.TreeNode;
import java.util.*;

public class QAmazon_BinaryTreeLeftSideView {

    public static void main(String[] args){
        QAmazon_BinaryTreeLeftSideView a = new QAmazon_BinaryTreeLeftSideView();
        System.out.println((a.leftview(
                TreeNode.createTestData("[1,2,3,4,5,null,6,7,null,8,null,null,null,null,null]")
        )));
    }
//    bfs
//    public List<Integer> leftview(TreeNode root){
//        List<TreeNode> level=new ArrayList<>();
//        List<Integer> ans =new ArrayList<>();
//        level.add(root);
//
//        while (!level.isEmpty()){
//            ans.add(level.get(0).val);
//            List<TreeNode> newlevel=new ArrayList<>();
//            for (TreeNode node: level){
//                if (node.left!=null)
//                    newlevel.add(node.left);
//                if (node.right!=null)
//                    newlevel.add(node.right);
//            }
//            level=newlevel;
//        }
//        return ans;
//    }

       // dfs

        public List<Integer> leftview(TreeNode root){
            if (root==null) return new ArrayList<Integer>();
            List<Integer> leftside=leftview(root.left);
            List<Integer> rightside=leftview(root.right);
            List<Integer> views= new ArrayList<>();
            views.add(root.val);
            views.addAll(leftside);
            if (rightside.size()>leftside.size())
                views.addAll(rightside.subList(leftside.size(),rightside.size()));
            return views;
        }
}