package org.barry.algorithm.offer2;

import org.barry.algorithm.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/1/25 14:59
 */
public class P045 {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        int res = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = size; i > 0; i--) {
                TreeNode node = deque.poll();
                if (i == size) {
                    res = node.val;
                }
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
        }

        return res;
    }
}
