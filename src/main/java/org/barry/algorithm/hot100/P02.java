package org.barry.algorithm.hot100;

import org.barry.algorithm.ListNode;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/2/9 14:28
 */
public class P02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jin = 0;
        ListNode newList = new ListNode(0, null), cur = newList;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int val = val1 + val2 + jin;
            jin = val / 10;
            cur.next = new ListNode(val % 10, null);
            cur = cur.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (jin != 0) {
            ListNode node = new ListNode(jin, null);
            cur.next = node;
            cur = cur.next;
        }
        return newList.next;
    }
}
