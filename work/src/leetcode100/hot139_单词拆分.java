package leetcode100;


import java.util.Arrays;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 * https://leetcode.cn/problems/linked-list-cycle/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot139_单词拆分 {
    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(wordBreak(s, wordDict));
    }

    /**
     * 动态规划
     * dp[i]表示s的前i位能够由字典中的元素拼起来
     * 转移方程为dp[i] = dp[j] && check(j,i)，check(j,i)为判断j,i是不是在dict中，这里注意dp[j]是前j位，check(j,i)是第j + 1位到第i位
     * 时间复杂度：O(n方)
     * 空间复杂度：O(n)
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty() || wordDict.isEmpty()) {
            return false;
        }
        // 以为dp数组，s的前i位能够由字典中的元素拼起来
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            // 双层for循环找切分点j
            for (int j = 0; j < i; j++) {
                // 判断j到i是不是在dict中，其实就是截止前i个元素（包含第i个）
                boolean exitIndict = wordDict.contains(s.substring(j, i));
                if (dp[j] && exitIndict) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}