package LinkedList;

import LinkedList.structure.ListNode;


public class Q206_ReverseLinkedList {

    public static void main(String[] args){
        Q206_ReverseLinkedList a = new Q206_ReverseLinkedList();
        ListNode.print(a.reverseList(
                ListNode.createTestData("[2,4,3]")
        ));
    }


//    public ListNode reverseList(ListNode head) {
//        if (head==null || head.next==null)
//            return head;
//        ListNode newhead=reverseList(head.next);
//        head.next.next=head;
//        head.next=null;
//        return newhead;
//
//    }


    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        while (head!=null){
            ListNode newhead=head.next;
            head.next=pre;
            pre=head;
            head=newhead;
        }
        return pre;
    }
}