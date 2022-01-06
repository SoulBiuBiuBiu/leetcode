package org.barry.algorithm.offer2;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/1/6 9:17
 */
public class P004 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num : nums) {
                total += ((num) >> i) & 1;
            }
            if (total % 3 != 0) {
                res |= (1 << i);
            }
        }
        return res;
    }
}
