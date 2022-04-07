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
        //dp[i][1] 不持有 正常
        //dp[i][2] 不持有 冷冻期
        // 持有= 最大值（昨天不持有  今天买入，维持昨天持有）
        //dp[i][0]=Math.max(dp[i-1][1]-prices[i],dp[i-1][0]);
        // 不持有= 最大值（昨天冷冻期过度，维持昨天不持有）
        //dp[i][1]=Math.max(dp[i-1][2],dp[i-1][1])
        // 冷冻期=  昨天卖掉
        //dp[i][2]= dp[i-1][0]+prices[i];
        int len = prices.length;
        int[][] dp = new int[len][3];

        dp[0][0] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][2], dp[i - 1][1]);
            dp[i][2] = dp[i - 1][0] + prices[i];
        }
        return Math.max(dp[len - 1][1], dp[len - 1][2]);
    }
}
