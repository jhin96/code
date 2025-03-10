package leetcode100;


/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s 的，而不是部分字符串。
 *
 * https://leetcode.cn/problems/regular-expression-matching/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot10_正则表达式匹配 {

    public static void main(String[] args) {
        hot10_正则表达式匹配 hot10_正则表达式匹配 = new hot10_正则表达式匹配();
        boolean valid = hot10_正则表达式匹配.isMatch("aaa", "ab*ac*a");
    }

    /**
     * 二维动态规划，dp[i][j]表示s的前i位能否使用p的前j位进行匹配
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(m*n)
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        // 初始化dp[i][0] = false
        dp[0][0] = true;
        // 初始化dp[0][j]，j=1肯定为false
        for (int j = 2; j <= n; j++) {
            // *消除了前一位元素
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c = p.charAt(j - 1);
                if (c == '.') {
                    // 匹配了当前字符
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (c == '*') {
                    // 第一位不能为*；*可以将前一个变为空，此时取决于i,j-2 或 i=j-1取决于i-1和j匹配
                    if (j - 2 >= 0) {
                        boolean valid = p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1);
                        dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && valid);
                    }
                } else {
                    // c为普通字母，取决于前一位
                    dp[i][j] = dp[i - 1][j - 1] && s.charAt(i - 1) == c;
                }
            }
        }

        return dp[m][n];
    }

}
