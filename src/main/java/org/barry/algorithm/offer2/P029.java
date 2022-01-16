package org.barry.algorithm.offer2;

import org.barry.algorithm.Node;

public class P029 {
    public Node insert(Node head, int insertVal) {

        //处理为空的情况
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }

        int min = head.val;
        int max = head.val;

        Node cur = head.next;

        if (head.val <= insertVal && cur.val >= insertVal){//一开始就是插入点
            Node t = new Node(insertVal);
            t.next = head.next;
            head.next = t;
            return head;
        }

        while (cur != head) {

            int val = cur.val;
            min = Math.min(min, val);
            max = Math.max(max, val);

            if (cur.next.val >= insertVal && val <= insertVal) {
                Node node = new Node(insertVal);
                node.next = cur.next;
                cur.next = node;
                return head;
            }
            cur = cur.next;
        }

        if (insertVal >= max || insertVal <= min) {
            cur = head;
            while (cur.val != max || cur.next.val != min) {
                cur = cur.next;
            }
            Node node = new Node(insertVal);
            node.next = cur.next;
            cur.next = node;
        }
        return head;
    }
}
