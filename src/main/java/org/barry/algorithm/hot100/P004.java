package org.barry.algorithm.hot100;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/4/12 10:32
 */
public class P004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;

        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;

    }

    private double getKth(int[] nums1, int l1, int r1, int[] nums2, int l2, int r2, int k) {
        int len1 = r1 - l1 + 1;
        int len2 = r2 - l2 + 1;

        if (len1 > len2) return getKth(nums2, l2, r2, nums1, l1, r1, k);
        if (len1 == 0) return nums2[l2 + k - 1];

        if (k == 1) return Math.min(nums1[l1], nums2[l2]);

        int i = l1 + Math.min(len1, k / 2) - 1;
        int j = l2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, l1, r1, nums2, j + 1, r2, k - (j - r2 + 1));
        } else {
            return getKth(nums1, i + 1, r1, nums2, l2, r2, k - (i - l1 + 1));
        }
    }
}
