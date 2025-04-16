package newhot;

public class newhot198_打家劫舍 {

    public int rob(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n + 1];
        // 只需要初始化dp[1]就行
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }

}
