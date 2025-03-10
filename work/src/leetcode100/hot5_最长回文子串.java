package leetcode100;


/**
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 *
 * https://leetcode.cn/problems/longest-palindromic-substring/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot5_最长回文子串 {

    public static void main(String[] args) {
        hot5_最长回文子串 hot5_最长回文子串 = new hot5_最长回文子串();
        String bababss = hot5_最长回文子串.longestPalindrome("babad");
        System.out.println();
    }

    /**
     * 动态规划，dp[i][j]表示i-j是否为回文子串
     * 时间复杂度：O(n方)
     * 空间复杂度：O(n方)
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        int left = 0;
        int right = 0;
        int max = 1;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        // 初始化对角线
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        // 注意遍历顺序
        for (int n = 1; n < len; n++) {
            for (int m = 0; m < n; m++) {
                if (s.charAt(m) == s.charAt(n) && (m + 1 == n || dp[m + 1][n - 1])) {
                    dp[m][n] = true;
                    if (n - m + 1 > max) {
                        max = n - m + 1;
                        left = m;
                        right = n;
                    }
                }
            }
        }

        return s.substring(left ,right + 1);
    }

    /**
     * 中心扩散，难点是处理扩散的起始点，比如bb和aaa这种
     * 时间复杂度：O(n方)
     * 空间复杂度：O(1)
     *
     * @param s
     * @return
     */
    public String method1(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        int max = 1;
        int left = 0;
        int right = 0;
        char[] charArray = s.toCharArray();
        // 从第一个元素开始向两边扩散，需要考虑两种情况
        for (int i = 0; i < charArray.length; i++) {
            // 单数和双数都需要考虑
            int len1 = getLen(charArray, i , i);
            int len2 = getLen(charArray, i, i + 1);
            int len = Math.max(len1, len2);
            // 更新res
            if (len > max) {
                max = len;
                left = i - (len - 1) / 2;
                right = left + len - 1;
            }
        }

        return s.substring(left ,right + 1);
    }

    public int getLen(char[] charArray, int start, int end) {
        while (start >= 0 && end <= charArray.length - 1 && charArray[start] == charArray[end]) {
            start--;
            end++;
        }
        return end - start - 1;
    }

    public String error(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        int res = 0;
        // dp[i]表示截止i为止最大回文子串长度
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            // 这么做不行，因为截止i不是一定要以i为结尾，不能用i - dp[i - 1] - 1
            if (i - dp[i - 1] - 1 >= 0 && s.charAt(i) == s.charAt(i - dp[i - 1] - 1)) {
                dp[i] = dp[i - 1] + 2;
            }
            dp[i] = Math.max(dp[i], dp[i - 1]);
            res = Math.max(res, dp[i]);
        }

        return null;
    }

}
