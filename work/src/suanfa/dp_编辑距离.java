package suanfa;

public class dp_编辑距离 {

    public static void main(String[] args) {
        dp_编辑距离 dp_编辑距离 = new dp_编辑距离();
        int i = dp_编辑距离.minDistance("intention", "execution");
        System.out.println(i);
    }

    /**
     * 动态规划
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.isEmpty() || word2 == null || word2.isEmpty()) {
            return word1.isEmpty() ? word2.length() : word1.length();
        }

        // dp[i][j]表示将word1的前i位转为word2的前j位所需要的最小步数
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // 初始化
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= word2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                char char1 = word1.charAt(i - 1);
                char char2 = word2.charAt(j - 1);
                if (char1 == char2) {
                    // 不需要做任何变换
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // word1 -> word2 可以删除i,j-1、替换i-1,j-1、添加i-1,j
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }

            }
        }
        return dp[word1.length()][word2.length()];
    }

}
