package leetcode100;


/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 * https://leetcode.cn/problems/unique-binary-search-trees/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot96_不同的二叉搜索树 {

    /**
     * 需要画图理解
     * 每个节点都能做为根节点，然后两边节点是从0个开始一直到n-1个，则n的状态跟n-1有关，动态规划
     * 时间复杂度：O(n方)
     * 空间复杂度：O(n)
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        // 初始化dp[0]，没有节点也算一个
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            // 遍历左右两边的
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

}
