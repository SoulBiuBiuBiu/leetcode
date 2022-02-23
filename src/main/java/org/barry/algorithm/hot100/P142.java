package org.barry.algorithm.hot100;

import org.barry.algorithm.ListNode;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/2/23 15:40
 */
public class P142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            if (fast == slow) {
                ListNode prt = head;
                while (prt != slow) {
                    prt = prt.next;
                    slow = slow.next;
                }
                return prt;
            }
        }
        return null;
    }
}
