package org.barry.algorithm.offer2;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/1/7 10:07
 */
public class P008 {
    public int minSubArrayLen(int target, int[] nums) {
        int pre = 0, tail = 0, sum = 0, res = Integer.MAX_VALUE;
        int length = nums.length;
        while (tail < length) {
            sum += nums[tail];
            while (sum >= target) {
                res = Math.min(res, tail - pre + 1);
                sum -= nums[pre];
                pre++;
            }
            tail++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
