package org.barry.algorithm.hot100;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/2/9 15:02
 */
public class P05 {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(i, i, s);
            String s2 = palindrome(i, i + 1, s);
            if (Math.max(s1.length(), s2.length()) > res.length()) {
                res = s1.length() > s2.length() ? s1 : s2;
            }
        }
        return res;
    }

    private String palindrome(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

}
