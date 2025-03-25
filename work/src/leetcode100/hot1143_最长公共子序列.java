package leetcode100;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 * https://leetcode.cn/problems/longest-common-subsequence/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class hot1143_最长公共子序列 {

    /**
     * 常规二维dp
     * 时间复杂度：O(mn)
     * 空间复杂度：O(mn)
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.isEmpty() || text2 == null || text2.isEmpty()) {
            return 0;
        }
        int m = text1.length();
        int n = text2.length();
        // dp[i][j]表示text1的前i位于text2的前j位能组成的最长子序列
        int[][] dp = new int[m + 1][n + 1];
        // 为0时最长子序列就是0，不需要初始化
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 不需要dp[i - 1][j - 1]参与计算，因为之前dp[i - 1][j], dp[i][j - 1]的计算已经包括了dp[i - 1][j - 1]
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

}
