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
 * @since 2022/1/25 15:04
 */
public class P046 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root == null) {
            return res;
        }
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (i == size - 1) {
                    res.add(node.val);
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
