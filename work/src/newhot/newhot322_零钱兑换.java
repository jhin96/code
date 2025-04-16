package newhot;

public class newhot322_零钱兑换 {

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length < 1) {
            return 0;
        }
        // 前i个硬币凑成j的最小个数
        int[][] dp = new int[coins.length + 1][amount + 1];
        // 初始化
        for (int i = 1; i <= amount; i++) {
            // 表示无法凑成
            dp[0][i] = amount + 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                // 这个硬币不能用，只能拿前面的硬币凑
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 这个硬币能用，则不用这个硬币 or 用这个硬币
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }
        return dp[coins.length][amount] == amount + 1 ? -1 : dp[coins.length][amount];
    }

}
