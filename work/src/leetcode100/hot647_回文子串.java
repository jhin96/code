package leetcode100;


/**
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 *
 * https://leetcode.cn/problems/palindromic-substrings/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot647_回文子串 {

    /**
     * 动态规划，dp[i][j]表示i,j是不是一个回文子串(其实就是暴力遍历法，用dp[i+1][j-1]记录了上一步的状态)
     * 时间复杂度O(n方)，空间复杂度O(n方)
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int res = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        // 不能i,j都从0开始遍历，那样之前状态会没初始化
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                // 长度为1时i = j就是回文，长度超过1则需要看i+1,j-1
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                   res++;
                }
            }
        }
        return res;
    }

    /**
     * 中心扩散法，由一个字符或者两个字符开始，向两边扩散
     * 长度为n的字符串有2n - 1种中心点（1个字符+2个字符）
     * 时间复杂度O(n方)，空间复杂度O(1)
     *
     * @param s
     * @return
     */
    public int method2(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        int res = 0;
        // 注意这里遍历要把1个字符和2个字符的情况统一，这种
        for (int i = 0; i < 2 * n - 1; i++) {
            int l = i / 2;
            int r = l + i % 2;
            while (l >= 0 && r <= n - 1 && s.charAt(l) == s.charAt(r)) {
                r++;
                l--;
                res++;
            }
        }
        return res;
    }

    /**
     * 暴力遍历法，效率较低
     *
     * @param s
     * @return
     */
    public int method1(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (huiWen(s.substring(i, j + 1))) {
                    res++;
                }
            }
        }
        return res;
    }

    public boolean huiWen(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}