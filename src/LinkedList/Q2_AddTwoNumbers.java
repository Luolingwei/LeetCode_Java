package LinkedList;
import LinkedList.structure.ListNode;


public class Q2_AddTwoNumbers {


    public static void main(String[] args){
        Q2_AddTwoNumbers a = new Q2_AddTwoNumbers();
        ListNode.print(a.addTwoNumbers(
                ListNode.createTestData("[2,4,3]"),
                ListNode.createTestData("[5,6,4]")
        ));
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre= new ListNode(0);
        ListNode root=pre;
        int carry=0;
        while (l1!=null || l2!=null || carry!=0){
            if (l1!=null){
                carry+=l1.val;
                l1=l1.next;
            }
            if (l2!=null){
                carry+=l2.val;
                l2=l2.next;
            }
            pre.next=new ListNode(carry%10);
            carry/=10;
            pre=pre.next;
        }
        return root.next;

    }

}
