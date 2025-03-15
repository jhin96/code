package leetcode100;


import java.util.Arrays;
import java.util.Stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * https://leetcode.cn/problems/largest-rectangle-in-histogram/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot84_柱状图中最大的矩形 {

    /**
     * 矩阵高度必为height[i]，求这个height[i]对应的最大宽度就行；
     * 转换为找到每个height[i]左边第一个比他小的l，右边第一个比他小的r，宽度为r-l-1（不包括l、r）
     * 转化为经典的找到右边第一个比x大/小的元素，单调栈
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length < 1) {
            return 0;
        }
        int n = heights.length;
        // 记录左、右第一个比当前元素小的下标，没有则为-1、n
        int[] left = new int[n];
        int[] right = new int[n];
        // 存储下标
        Stack<Integer> stack = new Stack<>();

        // 初始化right
        Arrays.fill(right, n);
        for (int i = 0; i < n; i++) {
            // 当前元素小于栈顶了，则记录结果
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                Integer pop = stack.pop();
                right[pop] = i;
            }
            stack.push(i);
        }

        stack.clear();
        // 初始化left
        Arrays.fill(left, -1);
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                Integer pop = stack.pop();
                left[pop] = i;
            }
            stack.push(i);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
        }
        return res;
    }

}
