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


    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);
        return reursionPathSum(root, prefixSumCount, targetSum, 0);
    }

    private int reursionPathSum(TreeNode node, Map<Integer, Integer> prefixSumCount, int targetSum, int curSum) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        curSum += node.val;

        res += prefixSumCount.getOrDefault(curSum - targetSum, 0);

        prefixSumCount.put(curSum, prefixSumCount.getOrDefault(curSum, 0) + 1);

        res += reursionPathSum(node.left, prefixSumCount, targetSum, curSum);
        res += reursionPathSum(node.right, prefixSumCount, targetSum, curSum);

        prefixSumCount.put(curSum, prefixSumCount.getOrDefault(curSum, 0) - 1);
        return res;
    }

}
