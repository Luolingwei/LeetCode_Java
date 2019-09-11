package LinkedList;
import LinkedList.structure.ListNode;


public class Q21_MergeTwoSortedLists {
    public static void main(String[] args){
        Q21_MergeTwoSortedLists a = new Q21_MergeTwoSortedLists();
        ListNode.print(a.mergeTwoLists(
                ListNode.createTestData("[2,4,3]"),
                ListNode.createTestData("[5,6,4]")
        ));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead=new ListNode(0);
        ListNode p=prehead;
        while (l1!=null && l2!=null){
            if (l1.val<=l2.val) {
                p.next=l1;
                l1=l1.next;
            }
            else{
                p.next=l2;
                l2=l2.next;
            }
            p=p.next;
        }
        if (l1==null)
            p.next=l2;
        else
            p.next=l1;
        return prehead.next;
    }
}
