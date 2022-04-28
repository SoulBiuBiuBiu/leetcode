package org.barry.algorithm.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/2/9 15:50
 */
public class P015 {
    public static void main(String[] args) {
        new P015().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int target = -nums[i];
            //i+1 去重！！！
            int left = i + 1, right = n - 1;
            while (left < right) {
                int tmp = nums[left] + nums[right];
                if (target == tmp) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++; // 去重
                    while (left < right && nums[right] == nums[right - 1]) right--; // 去重
                    left++;
                    right--;
                } else if (tmp > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }
}
