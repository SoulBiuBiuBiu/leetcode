package org.barry.algorithm.offer2;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/1/10 9:58
 */
public class P012 {
    public int pivotIndex(int[] nums) {
        //全部元素之和:total  当遍历到第 i 个元素时，设其左侧元素之和为 sum, 右侧为 total-sum-nums[i], 左右相等为sum=total-sum-nums[i] ->  2*sum +nums[i]= total
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
