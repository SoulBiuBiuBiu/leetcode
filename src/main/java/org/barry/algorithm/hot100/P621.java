package org.barry.algorithm.hot100;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/3/16 10:17
 */
public class P621 {
    public static void main(String[] args) {
        new P621().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B' }, 2);
    }

    public int leastInterval(char[] tasks, int n) {
        int max = 0;
        int[] cnt = new int[26];

        for (int i = 0; i < tasks.length; i++) {
            cnt[tasks[i] - 'A']++;
            max = Math.max(cnt[tasks[i] - 'A'], max);
        }
        int min = ((max - 1) * (n + 1)) + 1;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == max) min++;
        }
        min--;
        return Math.max(min, tasks.length);
    }
}
