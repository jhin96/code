package leetcode100;


/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 * https://leetcode.cn/problems/longest-valid-parentheses/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot32_最长有效括号 {

    /**
     * dp[i]表示以i结尾的最长有效括号
     * i == ( 则dp[i] = 0
     * d == ) 时，i-1为(，则dp[i] = dp[i - 2] + 2
     * i-1为)，则需要去掉dp[i - 1]看i - dp[i - 1]处是什么
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                continue;
            }
            // 为')'时才能计算
            if (s.charAt(i - 1) == '(') {
                int pre = i - 2 >= 0 ? dp[i - 2] : 0;
                // 与i - 1组成一个括号
                dp[i] = pre + 2;
            } else {
                // 去掉前面有效括号后，能不能找到(匹配，否则不能组成以i结尾有效括号
                if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2;
                    // 还要加这个(之前的
                    if (i - dp[i - 1] - 2 >= 0) {
                        dp[i] += dp[i - dp[i - 1] - 2];
                    }

                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
