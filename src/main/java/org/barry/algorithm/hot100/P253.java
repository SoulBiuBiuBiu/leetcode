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
    public static void main(String[] args) {
        new P253().minMeetingRooms(new int[][]{{13, 15}, {1, 13}});
    }

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        int max = 0;

        for (int i = 0; i < intervals.length; i++) {
            int curStart = intervals[i][0];
            while (!priorityQueue.isEmpty() && priorityQueue.peek() <= curStart) {
                priorityQueue.poll();
            }
            priorityQueue.add(intervals[i][1]);
            max = Math.max(max, priorityQueue.size());
        }
        return max;
    }
}
