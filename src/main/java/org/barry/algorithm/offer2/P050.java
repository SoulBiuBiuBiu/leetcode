package org.barry.algorithm.offer2;

import org.barry.algorithm.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/4/26 16:29
 */
public class P050 {
    int sum = 0;

    public int pathSum(TreeNode root, int targetSum) {
        //前缀和
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        pathSum(root, targetSum, map, 0);
        return sum;
    }

    private void pathSum(TreeNode node, int targetSum, Map<Integer, Integer> map, int curSum) {
        if (node == null) {
            return;
        }
        if (map.containsKey(curSum + node.val - targetSum)) {
            sum += map.get(curSum + node.val - targetSum);
        }
        map.put(curSum + node.val, map.getOrDefault(curSum + node.val, 0) + 1);
        pathSum(node.left, targetSum, map, curSum + node.val);
        pathSum(node.right, targetSum, map, curSum + node.val);
        map.put(curSum + node.val, map.getOrDefault(curSum + node.val, 0) - 1);
    }
}
