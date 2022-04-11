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
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += isT(s, i, i);
            ans += isT(s, i, i + 1);
        }
        return ans;
    }

    int isT(String s, int left, int right) {
        int cnt = 0;
        while (left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            cnt++;
        }
        return cnt;
    }

}
