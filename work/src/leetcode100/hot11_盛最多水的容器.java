package leetcode100;


/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 *
 * https://leetcode.cn/problems/container-with-most-water/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot11_盛最多水的容器 {

    /**
     * 贪心算法，从两边开始遍历，因为宽度一直减少，所以每次长度小的那边移动
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height == null || height.length < 1) {
            return 0;
        }
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int weight = right - left;
            res = Math.max(res, Math.min(height[left], height[right]) * weight);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

}
