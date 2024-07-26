package org.example.ds.ll;
import org.example.ds.ll.LL.ListNode;

public class Reverse {
    public static ListNode reverseList(LL.ListNode head) {
        ListNode curr = head;
        ListNode prv = null;
        ListNode nxt;

        while (curr != null ) {
            nxt = curr.next;
            curr.next = prv;
            prv = curr;
            curr = nxt;
        }
        return prv;
    }

    //https://leetcode.com/problems/palindrome-linked-list/
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode first = head;

        while (fast!=null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = slow;
        ListNode prev = null;
        while (slow != null ) {
            fast = slow.next;
            slow.next = prev;
            prev = slow;
            slow = fast;
        }

        while ( prev != null)  {
            if ( prev.val != first.val) {
                return false;
            }
            prev = prev.next;
            first = first.next;
        }

        return true;
    }
}
