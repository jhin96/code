package suanfa;

public class tanxin_最大容量问题 {

    /**
     * 最大容量问题，求最大的两个板子能装多少水（板子宽度可以忽略不计），贪心算法策略
     * 初始化指针在两端，此时容量为(j-i) * min(h[i], h[j])，如果移动长板则容量一定变，因为小min(h[i], h[j])不变
     * 所以每次移动较短的板，更新res，最后得到结果
     *
     * @param ht
     * @return
     */
    public int maxCapacity(int[] ht) {
        if (ht == null || ht.length < 1) {
            return 0;
        }
        int left = 0;
        int right = ht.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(ht[left], ht[right]) * (right - left));
            if (ht[left] < ht[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

}
