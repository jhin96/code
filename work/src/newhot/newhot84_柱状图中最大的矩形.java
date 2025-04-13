package newhot;

import java.util.Arrays;
import java.util.Stack;

public class newhot84_柱状图中最大的矩形 {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length < 1) {
            return 0;
        }
        // 找到每个柱子左、右两边第一个比他小的
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        // 找右边第一个比height小的，没找到证明都是比这个大的，初始化为n
        Arrays.fill(right, n);
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }
        stack.clear();
        // 找左边第一个比height小的
        Arrays.fill(left, -1);
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                left[stack.pop()] = i;
            }
            stack.push(i);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // 以当前柱子为高的最大矩阵，不算left和right
            res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
        }
        return res;
    }

}
