package leetcode100;


/**
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot309_买卖股票的最佳时机含冷冻期 {

    public static void main(String[] args) {
        hot309_买卖股票的最佳时机含冷冻期 fuc = new hot309_买卖股票的最佳时机含冷冻期();
        int i = fuc.maxProfit(new int[]{1, 2, 3, 0, 2});
        System.out.println(i);
    }

    /**
     * 相当于3个一维dp配合完成任务，表示当天最大利润
     * dp[i][0]表示当天持有股票
     * dp[i][1]表示当天卖出但是不持有股票（不持有股票的话，需要区分是不是当天卖的）
     * dp[i][2]表示不是当天卖出，不持有股票
     * 这3个dp就能描述冷冻期
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][3];
        // 初始化，第一天
        dp[0][0] = -prices[0];

        for (int i = 1; i < n; i++) {
            // 这里不要考虑i-2,只考虑前一天的状态
            // 不是昨天卖的且当天买 or 前一天持有不变
            dp[i][0] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][0]);
            // 昨天持有了
            dp[i][1] = dp[i - 1][0] + prices[i];
            // 昨天或之前卖出，就是昨天肯定不持有
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
    }

}