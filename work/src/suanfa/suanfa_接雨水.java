package suanfa;

/**
 * https://leetcode.cn/problems/trapping-rain-water/
 *
 */
public class suanfa_接雨水 {

    /**
     * 给定一个柱子的数组，求能接多少雨水
     * 从早往右遍历找到截止当前的最大高度，从右往左同理
     * 每个地方能接到的雨水就是这两个数组的最小值 - 当前柱子高度
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int res = 0;
        // 其实可以不用初始化两端，因为接不到，算最小值-height也是0
        int[] maxLeft = new int[height.length];
        maxLeft[0] = height[0];
        int[] maxRight = new int[height.length];
        maxRight[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }
        for (int j = height.length - 2; j >= 0; j--) {
            maxRight[j] = Math.max(maxRight[j + 1], height[j]);
        }

        for (int k = 0; k < height.length; k++) {
            int tmpHeight = Math.min(maxLeft[k], maxRight[k]) - height[k];
            if (tmpHeight > 0) {
                res += tmpHeight;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        suanfa_接雨水 func = new suanfa_接雨水();
        int i = func.method1(new int[]{5,5,1,7,1,1,5,2,7,6});
        System.out.println(i);
    }

    /**
     * 从左往右找第一个大于等于当前柱子的，且不能相邻就能接到雨水，从右往左再来一遍，加起来就是答案
     * 但是这个处理不了两个问题：
     * 双重计算：从左到右和从右到左的扫描可能会导致某些区域的雨水被计算两次。（2,0,2这种）
     * 边界条件：在处理边界条件时，可能会出现一些问题，比如在处理越界时的 i 和 j 的调整
     * 逻辑错误：在寻找第一个大于等于当前柱子的过程中，可能会忽略一些情况，导致无法正确识别可以接雨水的区域
     *          （5,5,1,7,1,1,5,2,7,6处理第二个的时候会结束时left和i会是第一个7和6）
     *
     * @param height
     * @return
     */
    public int method1(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int res = 0;
        // 从左往右
        int i = 0;
        while (i < height.length) {
            int left = i;
            while (i < height.length && height[i] <= height[left]) {
                i++;
            }
            // 处理越界
            if (i == height.length) {
                i--;
            }
            if (i > left + 1 && height[i] >= height[left]) {
                // 计算结果
                for (int m = left; m < i; m++) {
                    res += (height[left] - height[m]);
                }
            }
            if (left == i) {
                i++;
            }
        }

        // 从右往左
        int j = height.length - 1;
        while (j > 0) {
            int right = j;
            while (j > 0 && height[j] <= height[right]) {
                j--;
            }
            if (j == -1) {
                j++;
            }
            if (j < right - 1 && height[j] >= height[right]) {
                // 计算结果
                for (int m = right; m > j; m--) {
                    res += (height[right] - height[m]);
                }
            }
            if (right == j) {
                j--;
            }
        }
        return res;
    }

}
