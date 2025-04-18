package newhot;

import java.util.List;

public class newhot139_单词拆分 {

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        // dp[i]表示第i位之前能否由wordDict组成
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String str : wordDict) {
                // 当前单词与后几位匹配，且前面为true
                if (i >= str.length() && s.substring(i - str.length(), i).equals(str) && dp[i - str.length()]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
