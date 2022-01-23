package org.barry.algorithm.offer2;

import java.util.Stack;

public class P039 {
    public int largestRectangleArea(int[] heights) {
        // 创建一个栈存放递增的柱子
        Stack<Integer> stack = new Stack<>();
        // 压入一个-1的下标，用来处理栈顶左侧没有柱子的情况
        stack.push(-1);
        // 记录最大矩形面积
        int maxArea = 0;
        // 遍历数组
        for (int i = 0; i < heights.length; i++) {
            // 若栈有柱子元素(-1是想象虚拟的柱子)，并且栈顶元素大于当前遍历的柱子高度执行逻辑
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                // 弹出栈顶元素，计算栈顶元素的最大矩形面积
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(height * width, maxArea);
            }
            stack.push(i);
        }
        // 遍历完数组后，栈可能还有柱子的执行逻辑
        while (stack.peek() != -1) {
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            maxArea = Math.max(height * width, maxArea);
        }
        return maxArea;
    }
}
