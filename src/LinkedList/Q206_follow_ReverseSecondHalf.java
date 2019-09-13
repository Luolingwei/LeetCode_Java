package LinkedList;

import LinkedList.structure.ListNode;

public class Q206_follow_ReverseSecondHalf {

    public static void main(String[] args){
        Q206_follow_ReverseSecondHalf a = new Q206_follow_ReverseSecondHalf();
        ListNode.print(a.reversehalf(
                ListNode.createTestData("[1,2,3,4,5,6]")
        ));
    }

    public ListNode reversehalf(ListNode head){
        ListNode slow=head, fast=head;
        while (fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        slow.next=reverseList(slow.next);
        return head;
    }

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
