package newhot;

import java.util.HashMap;
import java.util.Map;

public class newhot3_无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int res = 1;
        int left = 0;
        int right = 0;
        // map存储字符以及下标
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            // 出现重复元素则更新左下标
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

}
