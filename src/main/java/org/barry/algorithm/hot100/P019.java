package org.barry.algorithm.hot100;

import org.barry.algorithm.ListNode;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/2/9 16:28
 */
public class P019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head, dummy = new ListNode(0, head),p2=dummy;
        while (n != 0) {
            p1 = p1.next;
            n--;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return dummy.next;
    }
}
