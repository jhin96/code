package leetcode100;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * https://leetcode.cn/problems/longest-increasing-subsequence/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot300_最长递增子序列 {

    /**
     * dp[i]记录以i结尾的最大长度，第一轮遍历nums，第二轮遍历前面的，如有大于的证明可以拼起来则+1
     * 时间复杂度O(n方)
     * 空间复杂度O(n)
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int res = 1;
        // dp[i]表示以i结尾最长的递增序列长度
        int[] dp = new int[nums.length];
        // 初始化
        Arrays.fill(dp, 1);
        for (int i = 1; i< nums.length; i++) {
            // 遍历i之前的j，如果i比j大，则dp[i] = dp[j] + 1
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
