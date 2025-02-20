package suanfa;

import java.util.HashMap;
import java.util.Map;

public class huadongchuangkou_无重复字符的最长子串 {

    /**
     * 优化，可以不用删元素
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                // 取max的原因是因为可能不在滑动窗口内，不需要管，left不变就行
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            // 如果碰到同一元素，会保存靠右的
            map.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
     * 用一个map记录每个字符的索引，遍历右指针，碰到map里的元素说明有相同元素，更新左指针
     * 这个滑动窗口更好理解
     *
     * @param s
     * @return
     */
    public int method1(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                // 移动到这个元素的右边，并将中间的元素都删了
                int tmp = map.get(s.charAt(right)) + 1;
                for (int n = left; n < tmp; n++) {
                    map.remove(s.charAt(n));
                }
                left = tmp;
            }
            map.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

}
