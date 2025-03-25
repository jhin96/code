package newhot;

import java.util.HashSet;
import java.util.Set;

public class newhot128_最长连续序列 {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        // 记录出现过的数字
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 1;
        // 注意这里遍历set就行，不然会超时
        for (int num : set) {
            // 剪枝
            if (set.contains(num - 1)) {
                continue;
            }
            int max = 1;

            while (set.contains(num + 1)) {
                num++;
                max++;
            }
            res = Math.max(res, max);
        }
        return res;
    }

}
