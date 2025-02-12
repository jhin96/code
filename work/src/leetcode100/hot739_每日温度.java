package leetcode100;

import java.util.Stack;

/**
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 示例 1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 *
 * https://leetcode.cn/problems/daily-temperatures/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot739_每日温度 {

    public static void main(String[] args) {
        int[] data = new int[]{73,74,75,71,69,72,76,73};
        int[] res = dailyTemperatures(data);
        for (int i : res) {
            System.out.print(i);
            System.out.print(", ");
        }
    }

    /**
     * 暴力解法：双层for循环遍历列表（不采用）
     * 维护一个单调递减栈，存储元素下标；如果下一天温度更高，则出栈记录结果，结果下标就是当前下标，值是两个元素的下标相减
     *
     *
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length < 1) {
            return temperatures;
        }
        // 单调递减栈，存储元素下标
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            // 温度升高，记录结果（这里用while因为可能当前温度比之前几天都高，需要一直更新）
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            // 栈为空 或 温度降低则入栈
            stack.push(i);
        }
        return res;
    }

}
