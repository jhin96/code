package leetcode100;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 * https://leetcode.cn/problems/first-missing-positive/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class hot41_缺失的第一个正数 {

    /**
     * 将num防止在nums[num]的位置上，最后遍历得到结果
     * 空间复杂度O(1)
     * 时间复杂度O(n)，while多次执行，但是次数是线性的，不影响O(n)
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            // 需要避免被换过来的数字与这个数字一样导致死循环
            while (nums[i] != i + 1 && nums[i] <= nums.length && nums[i] > 0 && nums[i] != nums[nums[i] - 1]) {
                // 交换
                int tmpA = nums[i];
                int tmpB = nums[nums[i] - 1];
                nums[nums[i] - 1] = tmpA;
                nums[i] = tmpB;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    /**
     * 用set记录出现的元素，再从1开始遍历
     *
     * @param nums
     * @return
     */
    public int method1(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 1;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        // 证明数组里是1到length
        return nums.length + 1;
    }

}
