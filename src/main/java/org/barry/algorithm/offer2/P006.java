package org.barry.algorithm.offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/1/6 10:26
 */
public class P006 {
    //hash
    public int[] twoSum1(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{i, map.get(target - numbers[i])};
            }
        }
        return new int[]{0, 0};
    }

    //双指针
    public int[] twoSum(int[] numbers, int target) {
        int pre = 0, tail = numbers.length - 1;
        while (pre < tail) {
            int t = numbers[pre] + numbers[tail];
            if (t < target) {
                pre++;
            } else if (t > target) {
                tail--;
            } else {
                return new int[]{pre, tail};
            }
        }
        return new int[]{pre, tail};
    }
}
