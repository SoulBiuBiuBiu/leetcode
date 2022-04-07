package org.barry.algorithm.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/3/11 16:47
 */
public class P406 {
    public static void main(String[] args) {
        new P406().reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
        });
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o2[0] - o1[0];
                }
            }
        });

        ArrayList<int[]> ans = new ArrayList<>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
