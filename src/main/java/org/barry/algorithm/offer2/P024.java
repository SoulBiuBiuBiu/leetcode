package org.barry.algorithm.offer2;

import org.barry.algorithm.ListNode;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/1/13 9:27
 */
public class P024 {
    public ListNode reverseList(ListNode head) {
        ListNode h = new ListNode(0, null), cur = head;
        while (cur != null) {
            ListNode t = cur.next;
            cur.next=h.next;
            h.next=cur;
            cur = t;
        }
        return h.next;
    }
}
