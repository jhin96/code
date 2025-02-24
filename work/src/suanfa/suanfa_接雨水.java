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
        // 不需要初始化两端，因为接不到
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int j = height.length - 2; j >= 0; j--) {
            maxRight[j] = Math.max(maxRight[j + 1], height[j + 1]);
        }

        for (int k = 1; k < height.length - 1; k++) {
            int tmpHeight = Math.min(maxLeft[k], maxRight[k]) - height[k];
            if (tmpHeight > 0) {
                res += tmpHeight;
            }
        }
        return res;
    }

}
