package suanfa;

public class dp_完全背包 {

    /**
     * 01背包问题衍变，每个物体可以使用多次
     *
     * @param wgt
     * @param val
     * @param cap
     * @return
     */
    public int unboundedKnapsackDP(int[] wgt, int[] val, int cap) {
        if (wgt == null || wgt.length < 1 || val == null || val.length < 1 || cap < 1) {
            return 0;
        }
        // dp[i][j]表示前i个物体达到j容量时，最大价值
        int[][] dp = new int[wgt.length + 1][cap + 1];
        for (int i = 1; i <= wgt.length; i++) {
            for (int j = 1; j <= cap; j++) {
                if (wgt[i - 1] > j) {
                    // 不选择当前物体
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 选择当前物体，01背包中将i放入后只能从i-1中选取，可以重复用的话，就是仍然能从前i个中选取
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - wgt[i - 1]] + val[i - 1]);
                }
            }
        }

        return dp[wgt.length][cap];
    }

}
