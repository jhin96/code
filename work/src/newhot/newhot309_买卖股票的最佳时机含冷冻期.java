package newhot;

public class newhot309_买卖股票的最佳时机含冷冻期 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int n = prices.length;
        /**
         * dp表示当前利润
         * dp[i][0]：当天持有股票
         * dp[i][1]：当天不持有股票，并且是当天卖出
         * dp[i][2]：当天不持有股票，但不是当天卖出
         */
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            // 前一天持有 or 当前卖出，要求前一天不持有且不是前一天卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            // 当天卖出，前一天一定持有
            dp[i][1] = dp[i - 1][0] + prices[i];
            // 前一天不能持有，因为不是当天卖出
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        // 因为已经包含了当天所有情况的最大利润，res不需要在每一天更新
        return Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
    }

}