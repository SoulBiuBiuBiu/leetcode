package org.barry.algorithm.hot100;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/2/9 15:33
 */
public class P011 {
    public static void main(String[] args) {
        new P011().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
    }

    public int maxArea(int[] height) {
        int length = height.length;
        int left = 0, right = length - 1;
        int maxAres = 0;

        while (left <= right) {
            maxAres = Math.max(maxAres, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxAres;
    }
}
