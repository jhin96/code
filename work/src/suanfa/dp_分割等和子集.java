package suanfa;

public class dp_分割等和子集 {

    /**
     * 将数组分成两个和相等的子数组
     * 就是找和为sum / 2的元素
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        // boolean[i][j]表示前i个元素能够凑成j
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        // 初始化，前i个凑0都是可以的
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 用不用当前元素，只要有一个true就行
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[nums.length][target];
    }

}
