package org.example.ds.ll;

public class LL {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    ListNode head = null;
    ListNode tail = null;

    public void insertEnd(int data) {
        ListNode newNode = new ListNode(data);
        if(head == null) {
            head = newNode;
        }
        else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public void display() {
        ListNode current = head;
        if(head == null) {
            System.out.println("List is empty");
        }
        while(current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

}
