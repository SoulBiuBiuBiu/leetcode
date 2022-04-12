package org.barry.algorithm.hot100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/3/18 16:31
 */
public class P739 {
    public static void main(String[] args) {
        new P739().dailyTemperatures(new int[]{
                73, 74, 75, 71, 69, 72, 76, 73});
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] res = new int[length];
        //当前单调递减
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            while (!queue.isEmpty() && temperatures[queue.getLast()] < temperatures[i]) {
                Integer prevIndex = queue.removeLast();
                res[prevIndex] = i - prevIndex;
            }
            queue.addLast(i);
        }
        return res;
    }
}
