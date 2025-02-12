package leetcode100;


import java.util.HashSet;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot128 {

    /**
     * 用hash表存储已经有的元素，然后一个个遍历
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 1;
        for (int value : set) {
            // 临时存储当次循环最大值
            int max = 1;
            int tmp = value;
            // 不加这步会超时，value-1肯定已经遍历过value所以可以剪枝
            if (set.contains(tmp - 1)) {
                continue;
            }
            while (set.contains(tmp + 1)) {
                max++;
                tmp++;
            }
            res = Math.max(res, max);
        }
        return res;
    }

}