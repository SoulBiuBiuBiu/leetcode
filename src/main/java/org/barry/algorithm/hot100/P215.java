package org.barry.algorithm.hot100;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/2/25 16:22
 */
public class P215 {
    //堆
    public int findKthLargest1(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int num : nums) {
            queue.add(num);
        }
        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }
        return queue.poll();

    }

    //快排
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int l = 0, r = nums.length - 1;
        int target = len - k;

        while (true) {
            int index = partition(nums, l, r);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                l = index + 1;
            } else {
                r = index - 1;
            }
        }
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        int i = l, j = r;

        while (i < j) {
            while (nums[j] >= pivot && i < j) j--;
            while (nums[i] <= pivot && i < j) i++;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int j, int i) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

}
