package org.barry.algorithm.offer2;

import org.barry.algorithm.TreeNode;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/1/25 15:12
 */
public class P047 {
    public TreeNode pruneTree(TreeNode root) {
        boolean helper = helper(root);
        if (helper) {
            return null;
        }
        return root;
    }

    boolean helper(TreeNode node) {
        if (node == null) {
            return true;
        }

        boolean left = helper(node.left);
        boolean right = helper(node.right);

        if (left && right && node.val == 0) {
            return true;
        }
        if (left) {
            node.left = null;
        }
        if (right) {
            node.right = null;
        }
        return false;
    }
}
