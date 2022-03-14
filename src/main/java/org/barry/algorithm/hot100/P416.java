package org.barry.algorithm.hot100;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/3/11 17:23
 */
public class P416 {
    public boolean canPartition(int[] nums) {
        //dp[i][j]  nums[..i]中是否可以组成 j
        //dp[i][j]= dp[i-1][j-nums[k]]


        int n = nums.length;

        if (n < 2) {
            return false;
        }

        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }

        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;

        if (maxNum > target) {
            return false;
        }

        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;

        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n - 1][target];
    }
}
