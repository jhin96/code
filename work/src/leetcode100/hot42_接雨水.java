package leetcode100;


import java.util.LinkedList;
import java.util.Stack;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * https://leetcode.cn/problems/trapping-rain-water/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot42_接雨水 {

    /**
     * 两个数组解决
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        // 从右往左，从左往右记录截止当前柱子的最大值
        int[] left = new int[height.length];
        left[0] = height[0];
        for (int i = 1; i < height.length - 1; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        int[] right = new int[height.length];
        right[height.length - 1] = height[height.length - 1];
        for (int j = height.length - 2; j > 0; j--) {
            right[j] = Math.max(right[j + 1], height[j]);
        }

        int res = 0;
        for (int m = 1; m < height.length - 1; m++) {
            res += Math.min(left[m], right[m]) - height[m];
        }
        return res;
    }

    /**
     * 单调栈，维护一个递减栈
     * 类似213这种，3入栈之后需要计算这个能接的雨水就是2和3的距离 * (min(2, 3) - 1)
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param height
     * @return
     */
    public int method1(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int res = 0;
        // 存储下标
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            // 破坏单调递减条件
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                // 已经不满足单调减了，一定要取出当前元素；最少需要3个柱子才能算
                Integer pop = height[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }
                int left = height[stack.peek()];
                int width = i - stack.peek() - 1;
                int high = Math.min(height[i], left) - pop;
                res += width * high;
            }
            stack.push(i);
        }
        return res;
    }

}
