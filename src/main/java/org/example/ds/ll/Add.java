package org.example.ds.ll;
import org.example.ds.ll.LL.ListNode;

public class Add {
    public ListNode addTwoNumbers(ListNode head, ListNode tail) {
        int sum = 0 , carry = 0, h1 =0, h2 = 0;
        ListNode ptr = new ListNode(0), h = ptr;

        while (head !=null || tail != null || carry !=0) {
            if( head == null) h1 = 0;
            else h1 = head.val ;
            if( tail == null) h2 = 0;
            else h2 = tail.val;

            sum = h1 + h2 + carry;
            carry = sum / 10;
            sum %= 10;

            ListNode temp = new ListNode(sum);
            h.next = temp;
            h = h.next;

            if (head != null) head = head.next;
            if( tail != null) tail = tail.next;

        }

        return ptr.next;

    }
}
