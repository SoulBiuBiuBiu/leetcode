package org.barry.algorithm.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/3/16 9:45
 */
public class P560 {
    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int curSum = 0;
        int res = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (map.containsKey(curSum - k)) {
                res += map.get(curSum - k);
            }
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);

        }
        return res;

    }
}
