package leetcode100;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * https://leetcode.cn/problems/minimum-window-substring/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot76_最小覆盖子串 {

    public static void main(String[] args) {
        hot76_最小覆盖子串 hot76_最小覆盖子串 = new hot76_最小覆盖子串();
        hot76_最小覆盖子串.minWindow("ADOBECODEBANC", "ABC");
    }

    /**
     * 滑动窗口，滑动右指针，如果满足条件则移动左指针，更新结果
     * 时间复杂度：O(j*m+n)，这里j=54，因为left移动一位就要valid一次，n是初始化tArr的时间
     * 空间复杂度：O(k)，k=128根据asc码创建了128长度的数组
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        // 初始化intArr
        int[] sArr = new int[128];
        int[] tArr = new int[128];
        for (char c : t.toCharArray()) {
            tArr[c]++;
        }

        int ansLeft = -1;
        int ansRight = s.length();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            sArr[s.charAt(right)]++;
            while (valid(sArr, tArr)) {
                // 更新res
                if (right - left < ansRight - ansLeft) {
                    ansRight = right;
                    ansLeft = left;
                }
                // 移动左指针
                sArr[s.charAt(left)]--;
                left++;
            }
            // 这个不能放前面，因为s(right)参与了valid，但是right++没有
            right++;
        }
        return ansLeft == -1 ? "" : s.substring(ansLeft, ansRight + 1);
    }

    /**
     * 判断s是否包含t
     *
     * @param sArr
     * @param tArr
     * @return
     */
    public boolean valid (int[] sArr, int[] tArr) {
        for (int i = 'a'; i <= 'z'; i++) {
            if (sArr[i] < tArr[i]) {
                return false;
            }
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            if (sArr[i] < tArr[i]) {
                return false;
            }
        }
        return true;
    }

}
