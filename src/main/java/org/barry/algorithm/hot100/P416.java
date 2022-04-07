package org.barry.algorithm.hot100;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/3/11 17:23
 */
public class P416 {
    public static void main(String[] args) {
        new P416().canPartition(new int[]{1, 5, 10, 6});
    }

    public boolean canPartition(int[] nums) {

        int length = nums.length;
        if (length < 2) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }


        int target = sum / 2;
        //dp[i][j] nums[..i]能否装满j
        boolean[][] dp = new boolean[length][target + 1];
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[length - 1][target];
    }
}
