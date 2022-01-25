package org.barry.algorithm.offer2;

import org.barry.algorithm.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/1/25 14:52
 */
public class P044 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root == null) {
            return res;
        }
        deque.add(root);

        while (!deque.isEmpty()) {
            int max = Integer.MIN_VALUE;
            for (int i = deque.size(); i > 0; i--) {
                TreeNode node = deque.poll();
                max = Math.max(node.val, max);
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}
