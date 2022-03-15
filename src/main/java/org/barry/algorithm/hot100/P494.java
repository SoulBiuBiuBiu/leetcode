package org.barry.algorithm.hot100;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/3/15 10:22
 */
public class P494 {
    public int findTargetSumWays(int[] nums, int target) {
        //背包问题 背包容量为target 物品为nums  nums不可以重复选择   0 1 背包问题
        //(sum-neg)-neg=sum-2*neg=target  neg=(sum-target)/2;
        // 条件 neg >=0  (sum-target)%2==0

        int sum = Arrays.stream(nums).sum();
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }

        int n = nums.length, neg = diff / 2;
        int[] dp = new int[neg + 1];

        dp[0] = 1;

        for (int num : nums) {
            for (int j = neg; j >= num; j--) {
                dp[j] += dp[j - num];
            }
            print(dp);
        }

        return dp[neg];
    }

    void print(int[] dp) {
        for (int d : dp) {
            System.out.print(d+" ");
        }
        System.out.println();
    }
}
