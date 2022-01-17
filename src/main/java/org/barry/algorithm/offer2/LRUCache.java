package org.barry.algorithm.offer2;

import java.util.HashMap;

class LRUCache {

    HashMap<Integer, Node> map = new HashMap<>();
    int capacity;
    Node tail, head;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail = new Node(0, 0);
        head = new Node(0, 0);
        tail.prev = head;
        tail.next = null;
        head.prev = null;
        head.next = tail;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 0);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
        lruCache.put(4, 4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        removeNode(node);
        appendToTail(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            appendToTail(node);
            node.val = value;
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            appendToTail(node);
            if (map.size() > capacity) {
                map.remove(head.next.key);
                removeNode(head.next);
            }
        }
    }

    private void appendToTail(Node node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    private void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.next = null;
        node.prev = null;
    }

    class Node {
        public Node next, prev;
        public int val, key;

        Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }
}