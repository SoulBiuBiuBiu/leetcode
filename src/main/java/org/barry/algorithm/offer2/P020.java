package org.barry.algorithm.offer2;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/1/12 10:14
 */
public class P020 {
    public int countSubstrings(String s) {
        //dp[i][j] 是否是回文
        //dp[i+1][j+1] = dp[i][j]&& s[i]==s[j];
        int ans = 0;
        int n = s.length();
        //回文中心有 2n-1个  l=
        for (int i = 0; i < 2 * n - 1; i++) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }
}
