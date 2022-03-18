package org.barry.algorithm.hot100;

import java.util.Stack;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/3/18 16:31
 */
public class P739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int t = st.pop();
                res[t] = i - t;
            }
            st.push(i);
        }
        return res;
    }
}
