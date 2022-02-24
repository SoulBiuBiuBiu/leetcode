package org.barry.algorithm.hot100;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    Node head, tail;
    int capacity;

    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail = new Node(0, 0);
        head = new Node(0, 0);
        tail.prev = head;
        tail.next = null;
        head.prev = null;
        head.next = tail;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            addToTail(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            addToTail(node);
            node.val = value;
        } else {
            Node node = new Node(key, value);
            addToTail(node);
            map.put(key, node);
            if (map.size() > capacity) {
                map.remove(head.next.key);
                remove(head.next);
            }
        }
    }

    void addToTail(Node node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    class Node {
        Node prev, next;
        int key, val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}