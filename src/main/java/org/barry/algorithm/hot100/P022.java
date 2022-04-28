package org.barry.algorithm.hot100;

import java.util.ArrayList;
import java.util.List;

public class P022 {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtraking(ans, sb, n, n);
        return ans;
    }

    private void backtraking(List<String> ans, StringBuilder sb, int left, int right) {
        if (right == 0) {
            ans.add(sb.toString());
        }
        if (left > 0) {
            sb.append("(");
            backtraking(ans, sb, left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > left) {
            sb.append(")");
            backtraking(ans, sb, left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
