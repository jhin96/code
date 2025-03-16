package leetcode100;

/**
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * https://leetcode.cn/problems/edit-distance/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot72_编辑距离 {

    /**
     * 动态规划
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(m*n)
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.isEmpty() || word2 == null || word2.isEmpty()) {
            return word1.isEmpty() ? word2.length() : word1.length();
        }
        int m = word1.length();
        int n = word2.length();
        // dp[i][j]表示将word1的前i位变为word2的前j位所需的最小步数
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 替换，删除，添加
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

}
