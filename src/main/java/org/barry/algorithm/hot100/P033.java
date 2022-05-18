package org.barry.algorithm.hot100;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/2/10 15:03
 */
public class P033 {
    public static void main(String[] args) {
        new P033().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            //如果 [l, mid - 1] 是有序数组
            if (nums[0] <= nums[mid]) {
                if (nums[mid] > target && nums[0] <= target) {
                    right = mid - 1;
                }
            }
            //如果 [mid, r] 是有序数组
        }
        return -1;
    }
}
