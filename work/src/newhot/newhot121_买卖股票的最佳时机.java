package newhot;

public class newhot121_买卖股票的最佳时机 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int res = 0;
        // 记录当前的最小值
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }

}