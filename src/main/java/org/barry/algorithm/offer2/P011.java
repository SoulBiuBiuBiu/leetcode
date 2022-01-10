package org.barry.algorithm.offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/1/10 9:33
 */
public class P011 {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int res = 0;
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i] == 0 ? -1 : 1;
            if (map.containsKey(pre)) {
                res = Math.max(res, i - map.get(pre));
            } else {
                map.put(pre, i);
            }
        }
        return res;
    }
}
