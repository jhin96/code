package suanfa;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 *
 * https://leetcode.cn/problems/subarray-sum-equals-k/description/
 *
 */
public class qianzuihe_和为K的子数组 {

    public static void main(String[] args) {
        qianzuihe_和为K的子数组 func = new qianzuihe_和为K的子数组();
        int i = func.subarraySum(new int[]{1,2,3}, 0);
        System.out.println(i);

    }

    /**
     * 用前缀和来做，用一个map存储各个前缀和出现的次数
     * pre[j] - pre[i] = k,则表示(i + 1，j)这个子数组和为k，那么就变为了求pre[j] - k，出现几次count加几
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int count = 0;
        int pre =0;
        // 存储前缀出现的次数，正常可以第一次for循环更新map，第二次再算答案，但是由于当前数字的前缀和只跟前一个有关，所以可以一次便利更行map
        Map<Integer, Integer> map = new HashMap<>();
        // 1，2，3找6这种情况处理不了，遍历到最后pre - k = 0，也算一种，所有需要初始化
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            // 必须先更新count，不然碰到找0，每一轮都会得到pre - k = 0然后结果+1,就会出错
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            // 更新或添加
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    /**
     * 两次遍历写法
     *
     * @param nums
     * @param k
     * @return
     */
    public int method1(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int res = 0;
        int[] pre = new int[nums.length];
        pre[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }
        // 存储前缀和与个数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < pre.length; i++) {
            if (map.containsKey(pre[i] - k)) {
                res += map.get(pre[i] - k);
            }
            map.put(pre[i], map.getOrDefault(pre[i], 0) + 1);
        }
        return res;
    }

}
