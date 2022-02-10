package org.barry.algorithm.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/2/10 15:47
 */
public class P046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(ans, row, nums, used);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> row, int[] nums, boolean[] used) {
        if (row.size() == nums.length) {
            ans.add(new ArrayList<>(row));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                row.add(nums[i]);
                used[i] = true;
                backtrack(ans, row, nums, used);
                used[i] = false;
                row.remove(row.size() - 1);
            }
        }
    }
}
