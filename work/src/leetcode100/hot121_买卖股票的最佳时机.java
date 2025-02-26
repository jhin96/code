package leetcode100;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot121_买卖股票的最佳时机 {

    /**
     * 用一个变量记录当前为止最小元素
     * 空间复杂度O(1)
     * 时间复杂度O(n)
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int res = 0;
        int pre = prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 先更新结果
            res = Math.max(res, prices[i] - pre);
            pre = Math.min(pre, prices[i]);
        }
        return res;
    }
}
