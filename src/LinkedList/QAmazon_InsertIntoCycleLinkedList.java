package LinkedList;

import LinkedList.structure.ListNode;

import java.util.*;

public class QAmazon_InsertIntoCycleLinkedList {

    public static void main(String[] args){
        QAmazon_InsertIntoCycleLinkedList a = new QAmazon_InsertIntoCycleLinkedList();
        ListNode.print(a.Insert(
                ListNode.createTestData("[2,4,3]"),7
        ));
    }

    // 两种情况，一种正常在升序序列插入，一种插入在交界点
    public ListNode Insert(ListNode head, int val){
        ListNode newhead=new ListNode(val);
        if (head==null){
            newhead.next=newhead;
            return newhead;
        }
        ListNode p=head;
        while (p!=head){
            if (p.val<=val && val<=p.next.val)
                break;
            if (p.val>p.next.val && (val>p.val || val<p.next.val))
                break;
            p=p.next;
        }
        newhead.next=p.next;
        p.next=newhead;
        return newhead;
    }

}
