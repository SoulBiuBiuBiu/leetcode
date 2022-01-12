package org.barry.algorithm.offer2;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/1/11 11:38
 */
public class P017 {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n < m) {
            return "";
        }

        String res = "";

        int[] cnt = new int[60];
        int startIndex = 0;
        int minLen = n + 1;

        for (int i = 0; i < m; i++) {
            cnt[t.charAt(i) - 'A']++;
        }
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'A']--;
            while (match(cnt)) {
                if (i - startIndex + 1 < minLen) {
                    minLen = i - startIndex + 1;
                    res = s.substring(startIndex, startIndex + minLen);
                }
                cnt[s.charAt(startIndex) - 'A']++;
                startIndex++;
            }
        }
        return res;
    }

    private boolean match(int[] cnt) {
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
