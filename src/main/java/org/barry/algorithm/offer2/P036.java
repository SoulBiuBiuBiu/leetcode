package org.barry.algorithm.offer2;

import java.util.Stack;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/1/20 10:00
 */
public class P036 {
    public static void main(String[] args) {
        new P036().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (Character.isDigit(token.charAt(0)) || (token.charAt(0) == '-' && token.length() != 1)){
                stack.push(Integer.parseInt(token));
            } else if ("+".equals(token)) {
                Integer i1 = stack.pop();
                Integer i2 = stack.pop();
                stack.push(i2 + i1);
            } else if ("-".equals(token)) {
                Integer i1 = stack.pop();
                Integer i2 = stack.pop();
                stack.push(i2 - i1);
            } else if ("*".equals(token)) {
                Integer i1 = stack.pop();
                Integer i2 = stack.pop();
                stack.push(i2 * i1);
            } else if ("/".equals(token)) {
                Integer i1 = stack.pop();
                Integer i2 = stack.pop();
                stack.push(i2 / i1);
            }
        }
        return stack.pop();
    }
}
