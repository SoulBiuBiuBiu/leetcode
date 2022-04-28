package org.barry.algorithm.hot100;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/4/26 18:07
 */
public class P072 {
    public int minDistance(String word1, String word2) {
        //dp[i][j] word1[..i] 变成 word2[..j] 最少需要多少步骤
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        //给A插入一个字符               dp[i][j]=
        //删除一个字符 = 给B插入一个字符  dp[i][j]=
        //替换一个字符                  dp[i][j]=
        return 0;
    }
}
