package org.barry.algorithm.hot100;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/4/22 11:54
 */
public class P010 {
    public boolean isMatch(String s, String p) {
        //dp[i][j] s[..i]与p[..j]是否匹配
        //if(p[j]=='.' || s[i]==p[j]) {dp[i][j]=dp[i-1][j-1]}
        //if(p[j]=='*')
        //  if(s[i]==p[j-1]||p[j-1]=='.')
        //      dp[i][j]= dp[i][j-2]|| dp[i-1][j]
        //  else
        //      dp[i][j]=dp[i][j-2];
        //
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        // s为空，p不为空，由于*可以匹配0个字符，所以有可能为true
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char cs = s.charAt(i - 1);
                char cp = p.charAt(j - 1);
                if (cs == cp || cp == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (cp == '*') {
                    if (cs == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j] || dp[i][j - 1];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[n][m];
    }
}
