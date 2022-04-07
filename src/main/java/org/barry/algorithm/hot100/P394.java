package org.barry.algorithm.hot100;

import java.util.Stack;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/3/11 11:32
 */
public class P394 {
    public static void main(String[] args) {
        new P394().decodeString("3[a]2[bc]");
    }

    public String decodeString(String s) {
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> integerStack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        StringBuilder isb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                isb.append(s.charAt(i));
            } else if (Character.isLetter(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else if (s.charAt(i) == '[') {
                Integer num = Integer.valueOf(isb.toString());
                isb = new StringBuilder();
                integerStack.push(num);
                stringStack.push(sb.toString());
                sb = new StringBuilder();
            } else if (s.charAt(i) == ']') {
                Integer num = integerStack.pop();
                StringBuilder tmp = new StringBuilder();
                while (num != 0) {
                    num--;
                    tmp.append(sb);
                }
                sb = new StringBuilder(stringStack.pop() + tmp);
            }
        }
        return sb.toString();
    }
}
