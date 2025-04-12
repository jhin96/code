package newhot;

import java.util.Stack;

public class newhot739_每日温度 {

    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length < 1) {
            return new int[0];
        }
        int[] res = new int[temperatures.length];
        // 维护一个递减栈
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                Integer pop = stack.pop();
                res[pop] = i - pop;
            }
            stack.push(i);
        }
        return res;
    }

}