package leetcode100;

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * https://leetcode.cn/problems/product-of-array-except-self/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot238_除自身以外数组的乘积 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int[] res = productExceptSelf(nums);
        for (int i : res) {
            System.out.println(i);
        }
    }

    /**
     * 使用两个数组，一个存储当前元素左边的乘积，一个存储当前元素右边的乘积
     * 空间复杂度O(n)
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new int[0];
        }
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        // 左边乘积
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }
        // 右边乘积
        right[nums.length - 1] = 1;
        for (int j = nums.length - 2; j >= 0 ; j--) {
            right[j] = nums[j + 1] * right[j + 1];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

    /**
     * 改进，一个数组，第二次遍历直接出结果
     * 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public static int[] method1(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new int[0];
        }
        int[] left = new int[nums.length];
        // 左边乘积
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }
        // 右边直接用中间量存储
        int right = 1;
        for (int j = nums.length - 1; j >= 0 ; j--) {
            left[j] *= right;
            // 下个循环前存储右边的元素
            right *= nums[j];
        }

        return left;
    }
}
