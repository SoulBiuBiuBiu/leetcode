package org.barry.algorithm.hot100;

import java.util.ArrayList;
import java.util.List;

public class P022 {
    int leftCnt = 0, rightCnt = 0;
    StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, n, 0);
        return ans;

    }

    private void backtrack(List<String> ans, int n, int cur) {
        if (cur == n * 2) {
            ans.add(sb.toString());
            return;
        }
        if (leftCnt < n) {
            sb.append("(");
            leftCnt++;
            backtrack(ans, n, cur + 1);
            leftCnt--;
            sb.deleteCharAt(sb.length() - 1);
        }
        if (rightCnt < n && rightCnt < leftCnt) {
            sb.append(")");
            rightCnt++;
            backtrack(ans, n, cur + 1);
            rightCnt--;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
