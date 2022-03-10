package org.barry.algorithm.hot100;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int[] tmp = new int[2];
            tmp[0] = entry.getKey();
            tmp[1] = entry.getValue();
            priorityQueue.add(tmp);
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = priorityQueue.poll()[0];
        }
        return ans;
    }
}
