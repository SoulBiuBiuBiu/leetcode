package org.barry.algorithm.offer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/1/7 9:42
 */
public class P007 {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        for (int i = 0; i < length - 2; i++) {
            //如果当前元素和前面一个元素一样，忽略重复元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int pre = i + 1, tail = length - 1;
            while (pre < tail) {
                int t = nums[pre] + nums[tail];
                if (t == -nums[i]) {
                    res.add(Arrays.asList(nums[i], nums[pre], nums[tail]));
                    // 去重
                    while (pre < tail && nums[pre] == nums[++pre]) ;
                    while (pre < tail && nums[tail] == nums[--tail]) ;
                } else if (t < -nums[i]) {
                    pre++;
                } else {
                    tail--;
                }
            }
        }
        return res;
    }
}
