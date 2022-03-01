package org.barry.algorithm.hot100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/3/1 18:17
 */
public class P253 {
    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;

        if (len == 0) {
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(len, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a-b;
            }
        });

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        minHeap.add(intervals[0][1]);

        for (int i = 1; i < len; i++) {
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.add(intervals[i][1]);
        }

        return minHeap.size();
    }
}
