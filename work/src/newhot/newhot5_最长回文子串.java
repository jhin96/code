package newhot;

public class newhot5_最长回文子串 {

    /**
     * 二维dp
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
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        // 初始化对角线
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        // 注意遍历顺序，14依赖23
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                // 注意条件，相等是一定要的，另外是i-1,j+1回文或者ij相邻或相等
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
                if (dp[i][j] && j - i + 1 > right - left + 1) {
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }

    /**
     * 中心扩散
     *
     * @param s
     * @return
     */
    public String method1(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        int left = 0;
        int right = 0;
        char[] charArray = s.toCharArray();
        // 遍历到最后一位，因为getLength算最后一位的时候len2=0
        for (int i = 0; i < charArray.length; i++) {
            // 考虑到ccc这种，需要计算两种情况
            int len1 = getLength(charArray, i, i);
            int len2 = getLength(charArray, i, i + 1);
            int maxLen = Math.max(len1, len2);
            if (maxLen > right - left + 1) {
                left = i - (maxLen - 1) / 2;
                right = i + maxLen / 2;
            }
        }
        return s.substring(left, right + 1);
    }

    public int getLength(char[] charArray, int start, int end) {
        while (start >= 0 && end <= charArray.length - 1 && charArray[start] == charArray[end]) {
            start--;
            end++;
        }
        // 注意这里是-1
        return end - start - 1;
    }

    /**
     * 类似最长有效括号算法，但是处理不了ccc这种情况
     *
     * @param s
     * @return
     */
    public String error(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        int left = 0;
        int right = 0;
        // 记录以i结尾最大回文串的长度
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            // 初始化dp[i]
            dp[i] = s.charAt(i) == s.charAt(i - 1) ? 2 : 1;
            // 将前一个回文跳过后，该字符等于回文前面的字符，则跟新dp[i]
            if (i - dp[i - 1] > 0 && s.charAt(i) == s.charAt(i - dp[i - 1] - 1)) {
                // 这里一定比2大
                dp[i] = dp[i - 1] + 2;
            }
            if (dp[i] > right - left + 1) {
                left = i - dp[i] + 1;
                right = i;
            }
        }
        return s.substring(left, right + 1);
    }

}
