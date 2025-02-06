package leetcode100;


/**
 * 给你一个整数数组nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * https://leetcode.cn/problems/maximum-product-subarray/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot152 {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 3, -4};
        System.out.println(maxProduct(nums));
    }

    /**
     * 为了解决负数问题，同时引入一个dp记录最小值就行
     * 并且不需要判断正负，直接更新两个dp数组就行
     *
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int res = nums[0];
        int[] dpMax = new int[nums.length];
        dpMax[0] = nums[0];
        int[] dpMin = new int[nums.length];
        dpMin[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
           // 最大值为max * nums || min * nums || nums；最小值同理
            dpMax[i] = Math.max( Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]), nums[i]);
            dpMin[i] = Math.min( Math.min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]), nums[i]);
            res = Math.max(res, dpMax[i]);
        }
        return res;
    }

    /**
     * 一维动态规划，dp[i]记录以i结尾的最大子数组乘积。这种方案不行，处理不好负号，过程中出现-2 3 -2这种导致结果为3
     *
     * @param nums
     * @return
     */
    public static int error(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = nums[0];
        // 初始化dp[0]
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] * nums[i], nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }

}