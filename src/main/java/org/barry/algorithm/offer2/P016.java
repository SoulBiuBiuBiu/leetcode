package org.barry.algorithm.offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/1/11 11:27
 */
public class P016 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 1;
        int pre = 0, tail = 0;
        int length = s.length();
        while (tail < length) {
            if (map.containsKey(s.charAt(tail))) {
                map.remove(s.charAt(pre++));
            } else {
                map.put(s.charAt(tail), 0);
                max = Math.max(max, tail - pre + 1);
                tail++;
            }
        }
        return max;
    }
}
