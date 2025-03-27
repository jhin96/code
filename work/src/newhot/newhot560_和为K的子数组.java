package newhot;

import java.util.HashMap;
import java.util.Map;

public class newhot560_和为K的子数组 {

    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int res = 0;
        // 前缀和，pre1-pre2=k，用map存下来各个前缀和对应个数，找pre(i)-k的个数就行
        Map<Integer, Integer> map = new HashMap<>();
        // 需要做一个初始化
        map.put(0, 1);
        int pre = 0;
        for (int num : nums) {
            pre += num;
            res += map.getOrDefault(pre - k, 0);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return res;
    }
    
}
