package newhot;

public class newhot32_最长有效括号 {

    public int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int res = 0;
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            // 右括号才计算
            if (s.charAt(i) == ')') {
                // 可以处理前一位是(的情况，因为dp[i - 1]肯定是0
                if (i > 0 && i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2;
                    // 加上(之前的
                    if (i - dp[i - 1] - 2 >= 0) {
                        dp[i] += dp[i - dp[i - 1] - 2];
                    }
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }

}
