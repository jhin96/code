package newhot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class newhot438_找到字符串中所有字母异位词 {

    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.isEmpty() || p == null || p.isEmpty() || s.length() < p.length()) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int[] sArr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            sArr[s.charAt(i) - 'a']++;
        }
        int[] pArr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pArr[p.charAt(i) - 'a']++;
        }
        // 滑动窗口
        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (Arrays.equals(sArr, pArr)) {
                res.add(i);
            }
            // 移动s窗口
            sArr[s.charAt(i) - 'a']--;
            // 找右边界，这样不需要单独处理第一组
            int end = Math.min(s.length() - 1, i + p.length());
            sArr[s.charAt(end) - 'a']++;
        }
        return res;
    }
    
}
