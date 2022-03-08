package org.barry.algorithm.hot100;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/3/4 17:34
 */
public class P309 {
    public int maxProfit(int[] prices) {
        //dp[i][0] 持有
        // 持有             dp[i][0]=Math.max(dp[i-1][2]-prices[i],dp[i-1][0])
        // 不持有 冷冻       dp[i][1]=dp[i-1][0]+prices[i]
        // 不持有 不冷冻     dp[i][2]=Math.max(dp[i-1][1],dp[i-1][2])

        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int[][] dp = new int[n][3];


        dp[0][0] = -prices[0];

        for (int i = 1; i < n; i++) {
            // 持有
            dp[i][0] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][0]);
            // 不持有 冷冻
            dp[i][1] = dp[i - 1][0] + prices[i];
            // 不持有 不冷冻
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }
}
