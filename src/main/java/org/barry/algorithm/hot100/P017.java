package org.barry.algorithm.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/2/9 16:21
 */
public class P017 {
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        List<String> ans = new ArrayList<>();
        if(digits.length()==0) return ans;
        backtrack(ans, phoneMap, digits, 0);
        return ans;
    }

    private void backtrack(List<String> ans, Map<Character, String> phoneMap, String digits, int index) {
        if (sb.length() == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        char digit = digits.charAt(index);
        String phone = phoneMap.get(digit);
        for (int i = 0; i < phone.length(); i++) {
            sb.append(phone.charAt(i));
            backtrack(ans, phoneMap, digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
