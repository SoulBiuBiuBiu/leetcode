package org.barry.algorithm.hot100;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/2/10 14:45
 */
public class P031 {
    public static void main(String[] args) {
        new P031().nextPermutation(new int[]{1, 3, 2});
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int maxIndex = 0;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                for (int j = n - 1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]) {
                        swap(nums, j, i - 1);
                        break;
                    }
                }
                Arrays.sort(nums, i, n);
                return;
            }
        }
        Arrays.sort(nums);
        return;
    }

    private void swap(int[] nums, int n, int maxIndex) {
        int tmp = nums[maxIndex];
        nums[maxIndex] = nums[n];
        nums[n] = tmp;
    }
}
