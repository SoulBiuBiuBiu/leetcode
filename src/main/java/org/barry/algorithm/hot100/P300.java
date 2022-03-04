package org.barry.algorithm.hot100;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/3/4 10:17
 */
public class P300 {
    public int lengthOfLIS(int[] nums) {
        //dp[i]  到下标i 最大的子序列之和
        int length = nums.length;
        int[] dp = new int[length];
        int ans=0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            ans = Math.max(dp[i], ans);
        }
        return ans + 1;
    }
}
