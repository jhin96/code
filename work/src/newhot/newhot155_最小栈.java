package newhot;

import java.util.Stack;

public class newhot155_最小栈 {

    Stack<Integer> stack;

    // 递减栈
    Stack<Integer> minStack;

    public newhot155_最小栈() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
    }

    public void pop() {
        Integer pop = stack.pop();
        if (pop.equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}