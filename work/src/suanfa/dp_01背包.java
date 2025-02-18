package suanfa;

public class dp_01背包 {

    public static void main(String[] args) {
        dp_01背包 method = new dp_01背包();
        int[] wgt = {10, 20, 30, 40, 50};
        int[] val = {50, 120, 150, 210, 240};
        System.out.println(method.knapsackDP(wgt, val, 50));
    }

    /**
     * wgt是重量，val是对应的价值，cap是背包容量，背包最大价值
     *
     * @param wgt
     * @param val
     * @param cap
     * @return
     */
    public int knapsackDP(int[] wgt, int[] val, int cap) {
        if (wgt == null || wgt.length < 1 || val == null || val.length < 1 || cap < 1) {
            return 0;
        }
        // dp[i]表示填满容积为i时，最大价值，这个思路不对
        // dp[i][j]表示前i个物品，达到容量j时的最大价值是多少
        int[][] dp = new int[wgt.length + 1][cap + 1];

        // 不需要初始化，i,j为0时dp[i][j] = 0
        for (int i = 1; i <= wgt.length; i++) {
            for (int j = 1; j <= cap; j++) {
                if (wgt[i - 1] > j) {
                    // 不能放入背包，与i-1一样
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 能放入背包，则需要比较放与不放两种情况
                    // 后面是i - 1是上一步的状态，选了通过+val[i - 1]表示
                    // 后面是i还是i-1需要具体问题具体分析，比如01背包和hot494目标和就是i-1，hot322零钱兑换就是i
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wgt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[wgt.length][cap];
    }

}
