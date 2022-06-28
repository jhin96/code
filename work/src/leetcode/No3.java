package leetcode;

import org.junit.Test;

import java.util.HashMap;

/**
 * 无重复字符的最长子串：
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是子串的长度，"pwke"是一个子序列，不是子串。
 *
 * @author Jhin
 * @create 2022-06-22 13:15
 */
public class No3 {

    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() < 1){
            return 0;
        }

        //双指针滑动窗口
        int i = 0;
        int j = 0;
        int res = Integer.MIN_VALUE;

        //存字符和下标
        HashMap<Character, Integer> map = new HashMap<>();

        while(j < s.length()){
            if(map.containsKey(s.charAt(j))){
                //找到重复位置的下一个
                i = Math.max(map.get(s.charAt(j)) + 1,i);
                //i = map.get(s.charAt(j)) + 1; 导致滑动窗口left回退，如abbbba
            }
            map.put(s.charAt(j),j);
            res = Math.max(res,j - i + 1);
            j++;
        }

        return res;

    }
}
