package leetcode100;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组是数组中的一个连续部分。
 *
 * https://leetcode.cn/problems/maximum-subarray/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot53_最大子数组和 {

    /**
     * 一维dp
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int res = nums[0];
        // dp[i]表示截止i的最大和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
