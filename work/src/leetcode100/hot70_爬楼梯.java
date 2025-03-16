package leetcode100;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * https://leetcode.cn/problems/climbing-stairs/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot70_爬楼梯 {

    /**
     * dp[i]只与前两项有关，优化
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    /**
     * 动态规划
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param n
     * @return
     */
    public int method2(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 递归，超时
     * 时间复杂度：O(2的n次方)
     * 空间复杂度：O(n)
     *
     * @param n
     * @return
     */
    public int method1(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        return method1(n - 1) + method1(n - 2);
    }

}
