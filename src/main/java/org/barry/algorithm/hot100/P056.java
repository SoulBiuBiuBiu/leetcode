package org.barry.algorithm.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/2/11 15:13
 */
public class P056 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(List.of(intervals[0][0], intervals[0][1])));
        for (int i = 1; i < intervals.length; i++) {
            List<Integer> pre = list.get(list.size() - 1);
            if (intervals[i][0] <= pre.get(1)) {
                pre.set(1, Math.max(intervals[i][1], pre.get(1)));
            } else {
                list.add(new ArrayList<>(List.of(intervals[i][0], intervals[i][1])));
            }
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i][0] = list.get(i).get(0);
            res[i][1] = list.get(i).get(1);
        }
        return res;
    }
}
