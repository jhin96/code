package newhot;

public class newhot279_完全平方数 {

    public int numSquares(int n) {
        if (n == 0) {
            return 0;
        }
        // dp[i]表示和为i的最小完全平方数个数
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 都能用1组成，初始化i
            dp[i] = i;
            // 遍历
            for (int j = 1; j * j <= i; j++) {
                // 每轮都会从按照i-1/4/9这个顺序更新
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

}
