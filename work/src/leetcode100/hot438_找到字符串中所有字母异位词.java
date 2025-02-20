package leetcode100;


import java.util.*;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot438_找到字符串中所有字母异位词 {

    /**
     * 维护一个滑动窗口，每次滑动时更新s子串的各个元素个数，最后比较出结果
     * (也可以在每次for循环式都new一个sArray，这样空间复杂度就高了)
     * 空间复杂度O(n)，这里n=26
     * 时间复杂度O(p + (s - p) * n)，每次判断equals用时n，就是两个for循环的时间，sp分别为长度
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.isEmpty() || p == null || p.isEmpty() || s.length() < p.length()) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        // 将2个滑动窗口都初始化出来
        int[] pArray = new int[26];
        int[] sArray = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pArray[p.charAt(i) - 'a']++;
            sArray[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sArray, pArray)) {
            res.add(0);
        }
        for (int i = 1; i <= s.length() - p.length(); i++) {
            // 将移出去的元素个数-1，添加的元素个数+1
            sArray[s.charAt(i - 1) - 'a']--;
            sArray[s.charAt(i + p.length() - 1) - 'a']++;
            if (Arrays.equals(sArray, pArray)) {
                res.add(i);
            }
        }
        return res;
    }

    /**
     * 按照p的长度来遍历s，每一个都判断是否为异位词，超时
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> method1(String s, String p) {
        if (s == null || s.isEmpty() || p == null || p.isEmpty() || s.length() < p.length()) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (judge(s.substring(i, i + p.length()), p)) {
                res.add(i);
            }
        }
        return res;
    }

    public boolean judge (String s, String p) {
        Map<Character, Integer> sMap = getCharMap(s);
        Map<Character, Integer> pMap = getCharMap(p);
        for (char c : sMap.keySet()) {
            if (sMap.get(c) != pMap.get(c)) {
                return false;
            }
        }
        return true;
    }

    public Map<Character, Integer> getCharMap (String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

}