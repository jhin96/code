package leetcode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * https://leetcode.cn/problems/perfect-squares/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot279_完全平方数 {

    public static void main(String[] args) {
        hot279_完全平方数 func = new hot279_完全平方数();
        int i = func.method1(12);
        System.out.println(i);
    }

    /**
     * 小于n的完全平方数凑成n的最小个数，动态规划
     * 时间复杂度O(n * nums.length)
     * 空间复杂度O(n * nums.length)
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        // 找到小于n的所有完全平方数
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            int num = i * i;
            if (num <= n) {
                nums.add(num);
            }
        }

        // dp[i][j]表示nums中前i个元素，凑成j所需要的最小个数
        int[][] dp = new int[nums.size() + 1][n + 1];
        // 初始化dp,dp[i][0] = 0,dp[0][j] = n + 1，因为最后n个1
        for (int j = 1; j <= n; j++) {
            dp[0][j] = n + 1;
        }
        for (int i = 1; i <= nums.size(); i++) {
            for (int j = 1; j <= n; j++) {
                if (nums.get(i - 1) > j) {
                    // 当前数不能用
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 当前数可以用
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - nums.get(i - 1)] + 1);
                }
            }
        }

        return dp[nums.size()][n];
    }

    /**
     * 类似零钱兑换的一维dp版本
     *
     * @param n
     * @return
     */
    public int method1(int n) {
        // dp[i]表示凑齐i需要的最小个数
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= n; j++) {
                int num = j * j;
                if (num <= i) {
                    dp[i] = Math.min(dp[i], dp[i - num] + 1);
                }
            }
        }
        return dp[n];
    }

}