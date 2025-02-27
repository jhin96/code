package leetcode100;

/**
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 * 求所能获得硬币的最大数量。
 *
 * https://leetcode.cn/problems/burst-balloons/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot312_戳气球 {

    public static void main(String[] args) {
        hot312_戳气球 fuc = new hot312_戳气球();
        int i = fuc.maxCoins(new int[]{3, 1, 5, 8});
        System.out.println(i);
    }

    /**
     * 二维dp，dp[i][j]表示i-j这个区间（不包括i和j）气球被戳破时，最大获取金额，需要引入一个变量k表示区间内最后被戳破的气球
     * dp[i][j] = dp[i][k] + dp[k][j] + nums[k] * nums[i] * nums[j]，因为k是最后一个，区间不包含i、j，所以是i*j*k
     * i需要从大到下，j需要从小到大遍历，1,3依赖于1,2和2,3
     * 时间复杂度O(n的3次方)
     * 空间复杂度O(n)方
     *
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int n = nums.length;
        // 因为不包含i、j，所以初始化需要+2
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n + 1; i >= 0; i--) {
            for (int j = 0; j <= n + 1; j++) {
                if (i + 1 >= j) {
                    // dp[i][i + 1] = 0
                    continue;
                }
                // 这里i和j不用做+1或-1运算
                int left = i >= n ? 1 : nums[i];
                int right = j >= n ? 1 : nums[j];
                // 遍历k
                for (int k = i + 1; k < j; k++) {
                    int numK = k >= n ? 1 : nums[k];
                    dp[i][j] = Math.max(dp[i][j] , dp[i][k] + dp[k][j] + left * right * numK);
                }
            }
        }
        return dp[0][n + 1];
    }

}