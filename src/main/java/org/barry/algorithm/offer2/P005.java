package org.barry.algorithm.offer2;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/1/6 9:32
 */
public class P005 {
    public int maxProduct(String[] words) {
        int[] wordCodes = initWordCode(words);
        int res = 0;
        for (int i = 0, end = words.length; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                if ((wordCodes[i] & wordCodes[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    private int[] initWordCode(String[] words) {
        int[] wordCode = new int[words.length];
        for (int i = 0, end = words.length; i < end; i++) {
            for (char letter : words[i].toCharArray()) {
                wordCode[i] |= (1 << (letter - 'a'));
            }
        }
        return wordCode;
    }
}
