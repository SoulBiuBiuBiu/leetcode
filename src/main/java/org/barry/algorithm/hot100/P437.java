package org.barry.algorithm.hot100;

import org.barry.algorithm.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/3/14 14:21
 */
public class P437 {
    Map<Integer, Integer> map = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        map.put(0, 1);
        return dfs(root, targetSum, 0);
    }

    private int dfs(TreeNode root, int targetSum, int curSum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        curSum += root.val;

        res = map.getOrDefault(curSum - targetSum, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        res += dfs(root.left, targetSum, curSum);
        res += dfs(root.right, targetSum, curSum);
        map.put(curSum, map.getOrDefault(curSum, 0) - 1);

        return res;
    }
}
