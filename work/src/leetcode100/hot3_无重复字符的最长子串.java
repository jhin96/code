package leetcode100;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 *
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot3_无重复字符的最长子串 {

    public static void main(String[] args) {
        hot3_无重复字符的最长子串 hot3_无重复字符的最长子串 = new hot3_无重复字符的最长子串();
        int i = hot3_无重复字符的最长子串.lengthOfLongestSubstring("ad");
        System.out.println(i);
    }

    /**
     * 用map存储元素以及下标，维护一个滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s== null || s.isEmpty()) {
            return 0;
        }
        int res = 1;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            // 此时窗口出现了相同元素，移动左指针
            if (map.containsKey(s.charAt(right)) && map.get(s.charAt(right)) >= left) {
                left = map.get(s.charAt(right)) + 1;
            }
            // 每轮都更新res
            res = Math.max(res, right - left + 1);
            map.put(s.charAt(right), right);
            right++;
        }
        return res;
    }

}
