package newhot;

public class newhot76_最小覆盖子串 {

    public String minWindow(String s, String t) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int min = Integer.MAX_VALUE;
        // 考虑不存在的情况
        int left = -1;
        int right = 0;
        // 需要考虑大小写
        int[] sArr = new int[128];
        int[] tArr = new int[128];
        for (char c : t.toCharArray()) {
            tArr[c]++;
        }
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            sArr[s.charAt(end)]++;
            // 更新res
            while (valid(sArr, tArr)) {
                if (end - start + 1 < min) {
                    min = end - start + 1;
                    left = start;
                    right = end;
                }
                sArr[s.charAt(start)]--;
                start++;
            }
        }
        return left == -1 ? "" : s.substring(left, right + 1);
    }

    /**
     * 判断是不是子串
     *
     * @param sArr
     * @param tArr
     * @return
     */
    public boolean valid(int[] sArr, int[] tArr) {
        for (int i = 0; i < 128; i++) {
            if (sArr[i] < tArr[i]) {
                return false;
            }
        }
        return true;
    }
    
}
