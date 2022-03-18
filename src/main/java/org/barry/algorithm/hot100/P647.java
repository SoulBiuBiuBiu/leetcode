package org.barry.algorithm.hot100;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/3/18 16:12
 */
public class P647 {
    public int countSubstrings(String s) {
        //dp[i][j] 表示字符串s在[i,j]区间的子串是否是一个回文串。
        //dp[i]][j]
        boolean[][] dp = new boolean[s.length()][s.length()];

        int ans = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    ans++;
                    dp[i][j] = true;
                }
            }
        }
        return ans;
    }
}
