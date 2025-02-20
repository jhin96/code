package suanfa;

import java.util.Arrays;

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的 排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 */
public class huadongchuangkou_字符串的排列 {

    /**
     * 还是两个滑动窗口解决问题
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty() || s1.length() > s2.length()) {
            return false;
        }
        int[] arrayS1 = new int[26];
        int[] arrayS2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arrayS1[s1.charAt(i) - 'a']++;
            arrayS2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(arrayS1, arrayS2)) {
            return true;
        }

        // 注意这里不能从0开始，equals操作必须放到循环结束处，不然想把最后一轮判断完后面会越界
        for (int i = 1; i <= s2.length() - s1.length(); i++) {
            arrayS2[s2.charAt(i - 1) - 'a']--;
            arrayS2[s2.charAt(i + s1.length() - 1) - 'a']++;
            if (Arrays.equals(arrayS1, arrayS2)) {
                return true;
            }
        }

        return false;
    }

}
