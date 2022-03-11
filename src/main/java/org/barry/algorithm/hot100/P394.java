package org.barry.algorithm.hot100;

import java.util.LinkedList;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/3/11 11:32
 */
public class P394 {

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();

        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(sb.toString());
                multi = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int times = stack_multi.removeLast();
                for (int i = 0; i < times; i++) {
                    tmp.append(sb);
                }
                sb = new StringBuilder(stack_res.removeLast() + tmp);
            } else if (Character.isDigit(c)) {
                multi = multi * 10 + (c - '0');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
