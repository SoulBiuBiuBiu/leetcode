package org.barry.algorithm.offer2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/1/20 9:34
 */
public class P035 {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 24 * 60) {
            return 0;
        }
        List<Integer> mins = new ArrayList<>();
        for (String t : timePoints) {
            String[] time = t.split(":");
            mins.add(Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]));
        }
        Collections.sort(mins);
        mins.add(mins.get(0) + 24 * 60);
        int min = 24 * 60;
        for (int i = 1; i < mins.size(); i++) {
            min = Math.min(min, mins.get(i) - mins.get(i - 1));
        }
        return min;
    }
}
