package org.barry.algorithm.offer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/1/11 11:20
 */
public class P015 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = s.length(), m = p.length();
        if (n < m) {
            return res;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        for (int i = 0; i < m; i++) {
            cnt1[s.charAt(i) - 'a']++;
            cnt2[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(cnt1, cnt2)) {
            res.add(0);
        }
        for (int i = m; i < n; i++) {
            cnt1[s.charAt(i) - 'a']++;
            cnt1[s.charAt(i - m) - 'a']--;
            if (Arrays.equals(cnt1, cnt2)) {
                res.add(i - m + 1);
            }
        }
        return res;
    }
}
