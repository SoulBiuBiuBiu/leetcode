package org.barry.algorithm.hot100;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/2/11 14:46
 */
public class P055 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int maxIndex=0;
        for (int i = 0; i < len; i++) {
            if (i > maxIndex) {
                return false;
            }
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }
        return true;
    }
}
