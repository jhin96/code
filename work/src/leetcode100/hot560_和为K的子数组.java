package leetcode100;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 *
 * https://leetcode.cn/problems/subarray-sum-equals-k/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot560_和为K的子数组 {

    /**
     * 前缀和模版题
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        // 用一个变量保存前缀和
        int pre = 0;
        for (int num : nums) {
            pre += num;
            if (map.containsKey(pre - k)) {
                res += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return res;
    }

}
