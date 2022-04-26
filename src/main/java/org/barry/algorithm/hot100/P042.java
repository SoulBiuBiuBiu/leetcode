package org.barry.algorithm.hot100;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/4/26 17:50
 */
public class P042 {
    public int trap(int[] height) {
        int n = height.length;
        if (n < 3) {
            return 0;
        }
        int res = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        left[n - 1] = height[n - 1];
        right[0] = height[0];
        for (int i = n - 2; i >= 0; i--) {
            left[i] = Math.max(left[i + 1], height[i]);
        }
        for (int i = 1; i < n; i++) {
            right[i] = Math.max(right[i - 1], height[i]);
        }

        for (int i = 1; i < n - 1; i++) {
            int min = Math.min(left[i + 1], right[i - 1]);
            if (height[i] < min) {
                res += min - height[i];
            }
        }
        return res;
    }
}
