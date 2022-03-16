package org.barry.algorithm.hot100;

import org.barry.algorithm.TreeNode;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/3/15 11:24
 */
public class P538 {
    int pre = 0;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        pre += root.val;
        root.val = pre;
        dfs(root.left);
    }
}
