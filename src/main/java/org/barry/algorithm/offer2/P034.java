package org.barry.algorithm.offer2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/1/18 17:01
 */
public class P034 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] cntOrder = new int[26];
        for (int i = 0; i < order.length(); i++) {
            cntOrder[order.charAt(i) - 'a'] = i;
        }
        String[] t = Arrays.copyOf(words, words.length);
        Arrays.sort(t, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char[] chars1 = o1.toCharArray();
                char[] chars2 = o2.toCharArray();
                int i = 0;
                while (i < chars1.length || i < chars2.length) {
                    if (i < chars1.length && i < chars2.length) {
                        if (cntOrder[chars1[i] - 'a'] > cntOrder[chars2[i] - 'a']) {
                            return 1;
                        } else if (cntOrder[chars1[i] - 'a'] < cntOrder[chars2[i] - 'a']) {
                            return -1;
                        } else {
                            i++;
                        }

                    } else if (i < chars1.length) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
                return 0;
            }
        });
        return Arrays.equals(t, words);
    }
}
