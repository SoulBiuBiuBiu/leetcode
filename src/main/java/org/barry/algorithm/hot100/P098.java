package org.barry.algorithm.hot100;

import org.barry.algorithm.TreeNode;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/2/16 16:21
 */
public class P098 {

    int preVal = Integer.MIN_VALUE;
    boolean first = true;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (root.val > preVal || (root.val == Integer.MIN_VALUE && first)) {
            preVal = root.val;
            first = false;
        } else {
            return false;
        }
        boolean right = isValidBST(root.right);
        return left && right;
    }
}
