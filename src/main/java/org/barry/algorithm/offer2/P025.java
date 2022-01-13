package org.barry.algorithm.offer2;

import org.barry.algorithm.ListNode;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/1/13 9:42
 */
public class P025 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode node = new ListNode(0, null), next = null;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            node = new ListNode(sum % 10, next);
            next = node;
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }
        return node;
    }

    public ListNode reverseList(ListNode head) {
        ListNode h = new ListNode(0, null), cur = head;
        while (cur != null) {
            ListNode t = cur.next;
            cur.next = h.next;
            h.next = cur;
            cur = t;
        }
        return h.next;
    }
}
