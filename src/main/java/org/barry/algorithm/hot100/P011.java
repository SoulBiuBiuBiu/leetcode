package org.barry.algorithm.hot100;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/2/9 15:33
 */
public class P011 {
    public int maxArea(int[] height) {
        // width * height;
        // height  由 左右两侧最高的取min
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left <= right) {
            res = Math.max(Math.min(height[left], height[right]) * (right - left), res);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
