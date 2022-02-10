package org.barry.algorithm.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/2/10 15:41
 */
public class P039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        backtrack(ans, row, candidates, target, 0, 0);
        return ans;
    }

    void backtrack(List<List<Integer>> ans, List<Integer> row, int[] candidates, int target, int sum, int index) {
        if (sum > target) return;
        if (sum == target) {
            ans.add(new ArrayList<>(row));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            row.add(candidates[i]);
            backtrack(ans, row, candidates, target, sum + candidates[i], i);
            row.remove(row.size() - 1);
        }
    }

}
