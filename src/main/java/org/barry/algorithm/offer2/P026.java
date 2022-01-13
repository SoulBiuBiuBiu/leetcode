package org.barry.algorithm.offer2;

import org.barry.algorithm.ListNode;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/1/13 10:04
 */
public class P026 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return ;
        }
        ListNode mid = middleNode(head);
        ListNode l1=head;
        ListNode l2=mid.next;
        mid.next=null;
        l2=revert(l2);
        merge(l1, l2);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode revert(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public void merge(ListNode l1, ListNode l2) {
        ListNode l1Temp, l2Temp;
        while (l1 != null && l2 != null) {
            l1Temp = l1.next;
            l2Temp = l2.next;

            l1.next = l2;
            l1 = l1Temp;

            l2.next = l1;
            l2 = l2Temp;
        }
    }

}
