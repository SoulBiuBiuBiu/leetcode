package org.barry.algorithm.hot100;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/3/8 9:41
 */
public class P322 {
    public int coinChange(int[] coins, int amount) {
        // dp[i] 组成i元 最少需要多少个硬币
        // dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }

            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
