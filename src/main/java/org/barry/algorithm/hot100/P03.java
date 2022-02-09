package org.barry.algorithm.hot100;

import java.util.HashSet;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/2/9 14:37
 */
public class P03 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int left = 0, right = 0;
        int maxLen = 1;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(i));
            right++;
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}
