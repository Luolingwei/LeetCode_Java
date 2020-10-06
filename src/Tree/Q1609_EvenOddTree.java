package Tree;

import LinkedList.structure.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q1609_EvenOddTree {


    public static void main(String[] args) {
        System.out.println(isEvenOddTree(TreeNode.createTestData("[1,10,4,3,null,7,9,12,8,6,null,null,2]")));
        System.out.println(isEvenOddTree(TreeNode.createTestData("[5,4,2,3,3,7]")));
        System.out.println(isEvenOddTree(TreeNode.createTestData("[11,8,6,1,3,9,11,30,20,18,16,12,10,4,2,17]")));
    }

    public static boolean isEvenOddTree(TreeNode root) {

        Queue<TreeNode> level = new LinkedList<>(Arrays.asList(root));
        boolean even = true;
        while (level.size()>0) {

            int curSize = level.size();
            int preVal = even? Integer.MIN_VALUE: Integer.MAX_VALUE;
            while (curSize-- >0) {
                TreeNode node = level.poll();
                if (even && (node.val<=preVal || node.val%2==0)) return false;
                if (!even && (node.val>=preVal || node.val%2!=0)) return false;
                preVal = node.val;
                if (node.left != null) level.add(node.left);
                if (node.right != null) level.add(node.right);
            }
            even = !even;
        }
        return true;

    }
}
