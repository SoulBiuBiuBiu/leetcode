package org.barry.algorithm.hot100;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/3/16 10:17
 */
public class P621 {
    public int leastInterval(char[] tasks, int n) {
        int[] chars = new int[26];
        int max=0;

        for (char task : tasks) {
            max = Math.max(++chars[task - 'A'], max);
        }

        int res = (max - 1) * (n + 1);
        for (int i = 0; i < 26; i++) {
            if (chars[i] == max) {
                res++;
            }
        }

        return Math.max(res, tasks.length);
    }
}
