package org.barry.algorithm.hot100;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/2/10 15:03
 */
public class P033 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        //二分查找的基础上
        int left = 0, right = n - 1;
        while (left <= right) {
            int index = (right + left) / 2;
            if (nums[index] == target) {
                return index;
            }
            if (nums[index] < nums[right]) {
                if (target > nums[index] && target <= nums[right]) {
                    left = index + 1;
                } else {
                    right = index - 1;
                }
            } else {
                if (target < nums[index] && target >= nums[left]) {
                    right = index - 1;
                } else {
                    left = index + 1;
                }
            }
        }
        return -1;
    }
}
