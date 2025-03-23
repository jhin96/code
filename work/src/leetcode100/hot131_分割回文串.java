package leetcode100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些 子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * https://leetcode.cn/problems/palindrome-partitioning/description/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class hot131_分割回文串 {

    public static void main(String[] args) {
        hot131_分割回文串 func = new hot131_分割回文串();
        List<List<String>> aab = func.partition("aab");
        System.out.println(aab);
    }

    /**
     * 回溯，dfs遍历每个回文子串，这里从第一个字符开始遍历之后所有可能子串就行
     * 时间复杂度：O(n * 2的n次方)，n是判断是否回文，2的n次方是多少种分割方法
     * 空间复杂度：O(n * 2的n次方)，递归深度最大为n，tmp也需要n，返回值不算的话是O(n)
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }
        List<List<String>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), s, 0);
        return res;
    }

    /**
     * dfs
     *
     * @param res
     * @param tmp
     * @param s
     * @param index
     */
    public void dfs (List<List<String>> res, List<String> tmp, String s, int index) {
        if (index >= s.length()) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        // 遍历以当前为起点所有可能的回文子串
        List<Integer> palindrome = getPalindrome(s, index);
        for (int i : palindrome) {
            tmp.add(s.substring(index, i + 1));
            dfs(res, tmp, s, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    /**
     * 返回index开始所有回文串的结束下标（包含index）
     *
     * @param s
     * @param index
     * @return
     */
    public List<Integer> getPalindrome (String s, int index) {
        List<Integer> res = new ArrayList<>();
        for (int i = index; i < s.length(); i++) {
            if (valid(s.substring(index, i + 1))) {
               res.add(i);
            }
        }
        return res;
    }

    public boolean valid(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
