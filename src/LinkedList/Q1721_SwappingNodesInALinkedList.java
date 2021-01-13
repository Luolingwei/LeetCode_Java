package LinkedList;

import LinkedList.structure.ListNode;

public class Q1721_SwappingNodesInALinkedList {


    public static void main(String[] args) {

        ListNode.print(swapNodes(
                ListNode.createTestData("[1,2,3,4,5]"), 2
        ));

        ListNode.print(swapNodes(
                ListNode.createTestData("[7,9,6,6,7,8,3,0,9,5]"), 5
        ));

        ListNode.print(swapNodes(
                ListNode.createTestData("[1]"), 1
        ));

        ListNode.print(swapNodes(
                ListNode.createTestData("[1,2]"), 1
        ));
    }


    public static ListNode swapNodes(ListNode head, int k) {
        ListNode p = head, q = head;
        for (int i=0; i<k-1; i++) q = q.next;
        ListNode left = q;
        while (q.next!=null){
            p = p.next;
            q = q.next;
        }
        int temp = left.val;
        left.val = p.val;
        p.val = temp;
        return head;
    }


}
