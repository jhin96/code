package newhot;

import java.util.Stack;

public class newhot42_接雨水 {

    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int res = 0;
        // 维护一个单调递减栈，栈存储下标
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            // 不满足单调递减栈条件
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                Integer pop = stack.pop();
                // 若栈空则不能接到雨水
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int width = i - left - 1;
                int length = Math.min(height[i], height[left]) - height[pop];
                res += width * length;
            }
            stack.push(i);
        }
        return res;
    }

    public int method1(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int m = height.length;
        // 从左到右、从右到左维护截止当前元素最大值(模拟画图理解)
        int[] left = new int[m];
        left[0] = height[0];
        for (int i = 1; i < m; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        int[] right = new int[m];
        right[m - 1] = height[m - 1];
        for (int j = m - 2; j >= 0; j--) {
            right[j] = Math.max(right[j + 1], height[j]);
        }
        int res = 0;
        for (int n = 1; n < m - 1; n++) {
            res += Math.min(left[n], right[n]) - height[n];
        }
        return res;
    }

}
