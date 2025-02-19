package suanfa;

public class dp_零钱兑换II {

    /**
     * 零钱兑换衍生问题，问凑出amt的种类
     *
     * @param coins
     * @param amt
     * @return
     */
    int coinChangeIIDP(int[] coins, int amt) {
        if (coins == null || coins.length < 1) {
            return -1;
        }
        // dp[i][j]表示前i个硬币凑成j的方案
        int[][] dp = new int[coins.length + 1][amt + 1];

        // 凑0都有一种方案，就是不拿硬币
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amt; j++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 用或者不用的方案都算上
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[coins.length][amt];
    }

}
