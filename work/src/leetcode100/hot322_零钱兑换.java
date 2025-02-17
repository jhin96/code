package leetcode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 *
 * https://leetcode.cn/problems/coin-change/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot322_零钱兑换 {

    /**
     * 动态规划
     * dp[i]表示组成金额i所需要的最少硬币数量
     * 状态转移方程为dp[i] = min(dp[i - j]) + 1；j为所有硬币的大小（每轮都需要全部遍历）
     * 时间复杂度O(amount * coins.size)
     * 空间复杂度O(amount)
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length < 1) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        // 不能用maxValue，因为后面涉及+1运算；其实用amount + 1就行，因为最小面值就是1块，最大的就是所有的都是1块组成
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        // 初始化
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }


    public int min = Integer.MAX_VALUE;

    /**
     * 每次都从最大往最小取
     * 这样的问题在于，第一个返回的结果肯定是最小的，其实后面就不用继续了，所以这个会超时
     * 优化，每次从index开始遍历（头一轮选择了i,i+1，这一轮就不需要i+1,i），但是依然超时
     *
     * @param coins
     * @param amount
     * @return
     */
    public int method1(int[] coins, int amount) {
        if (coins == null || coins.length < 1) {
            return -1;
        }
        sort(coins);
        dfs(coins, amount, 0, new ArrayList<>());
        return min == Integer.MAX_VALUE ? -1 : min;
    }


    public void dfs(int[] coins, int currentAmount, int index, List<Integer> coinList) {
        if (currentAmount == 0) {
            min = Math.min(min, coinList.size());
            return;
        }
        for (int i = index; i < coins.length; i++) {
            // 剪枝，凑不出来就不用继续了
            if (coins[i] > currentAmount) {
                continue;
            }
            coinList.add(coins[i]);
            dfs(coins, currentAmount -coins[i], i, coinList);
            coinList.remove(coinList.size() - 1);
        }
    }

    /**
     * 从大到小排序
     *
     * @param coins
     */
    public void sort(int[] coins) {
        Arrays.sort(coins);
        for (int i = 0; i < coins.length / 2; i++) {
            int j = coins.length - i - 1;
            int tmp = coins[i];
            coins[i] = coins[j];
            coins[j] = tmp;
        }
    }

}