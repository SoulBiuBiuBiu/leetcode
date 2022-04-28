package org.barry.algorithm.hot100;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/3/21 11:27
 */
public class P032 {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxLength = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                if (left > right) {
                    right++;
                } else {
                    left = 0;
                    right = 0;
                }
            }
            if (left == right) {
                maxLength = Math.max(maxLength, left * 2);
            }
        }
        left = right = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                right++;
            } else {
                if (right > left) {
                    left++;
                } else {
                    left = 0;
                    right = 0;
                }
            }
            if (left == right) {
                maxLength = Math.max(maxLength, left * 2);
            }
        }
        return maxLength;
    }
}

