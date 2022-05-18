package org.barry.algorithm.hot100;

import org.barry.algorithm.ListNode;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/5/18 15:05
 */
public class P143 {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;

        newHead = revertList(newHead);

        while (newHead != null) {
            ListNode tmp = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = tmp;
        }
    }

    private ListNode revertList(ListNode newHead) {
        ListNode dummy = new ListNode(0);
        while (newHead != null) {
            ListNode next = newHead.next;
            newHead.next = dummy.next;
            dummy.next = newHead;
            newHead = next;
        }
        return dummy.next;
    }
}
