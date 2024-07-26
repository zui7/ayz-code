package org.example.ds.cache;

import java.util.HashMap;

public class LRUByHMAndLL {
    private final int maxCap;

    static class Node{
        int key, value;
        Node prev, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    HashMap<Integer, Node> cacheMap;

    public LRUByHMAndLL(int capacity) {
        cacheMap = new HashMap<>(capacity);
        maxCap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(cacheMap.containsKey(key)) {
            Node temp = cacheMap.get(key);
            int val = temp.value;
            //      cache.remove(key);
            deleteNode(temp);
            addNodeFront(temp);
            //    cache.put(key, head.next);
            return val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cacheMap.containsKey(key)) {
            Node newNode = cacheMap.get(key);
            cacheMap.remove(key);
            deleteNode(newNode);
        }
        Node temp = new Node(key, value);
        addNodeFront(temp);
        cacheMap.put(key, temp);           //    cache.put(key, head.next);
        if(cacheMap.size() > maxCap) {
            cacheMap.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
    }

    private void addNodeFront(Node newNode) {
        head.next.prev = newNode;
        newNode.next = head.next;
        newNode.prev = head;
        head.next = newNode;
    }

    private void deleteNode(Node newNode) {
        newNode.prev.next = newNode.next;
        newNode.next.prev = newNode.prev;
    }

    public void printNode() {
        Node ptr = head.next;
        while(ptr!=tail) {
            System.out.print(ptr.value);
            ptr = ptr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUByHMAndLL cache = new LRUByHMAndLL(4);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);

        cache.printNode();
        cache.get(2);
        cache.get(4);
        System.out.println(cache.get(4));
        cache.printNode();
        cache.put(5,5);
        cache.get(6);
        cache.printNode();
    }
}
