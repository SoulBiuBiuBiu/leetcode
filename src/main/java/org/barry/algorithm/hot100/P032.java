package org.barry.algorithm.hot100;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/3/21 11:27
 */
public class P032 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int num : nums) {
            priorityQueue.add(num);
        }
        int res = 0;
        for (int i = 0; i <= k - 1; i++) {
            res = priorityQueue.poll();
        }
        return res;
    }
}

