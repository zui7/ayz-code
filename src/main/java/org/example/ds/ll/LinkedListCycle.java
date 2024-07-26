package org.example.ds.ll;
import org.example.ds.ll.LL.ListNode;

public class LinkedListCycle {

    //https://leetcode.com/problems/linked-list-cycle/
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {return true;}
        }
        return false;
    }

    //https://leetcode.com/problems/linked-list-cycle-ii/
    public ListNode detectNodeWhereCycleBegins(ListNode head) {
        ListNode slow = head;
        ListNode fast = slow;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if( slow == fast ) {
                slow = head;
                while(slow!=fast){
                    fast= fast.next;
                    slow= slow.next;
                }
                return slow;
            }
        }
        return null;
    }

}
