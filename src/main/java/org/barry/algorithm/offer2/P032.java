package org.barry.algorithm.offer2;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/1/17 11:22
 */
public class P032 {
    public boolean isAnagram(String s, String t) {
        if (s.equals(t)) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (char c :
                s.toCharArray()) {
            cnt1[c - 'a']++;
        }
        for (char c :
                t.toCharArray()) {
            cnt2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) {
                return false;
            }
        }
        return true;
    }
}
