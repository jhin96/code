package leetcode100;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 实现 MinStack 类:
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *
 * https://leetcode.cn/problems/min-stack/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot155 {

    public static void main(String[] args) {
        hot155 hot155 = new hot155();
        hot155.push(-2);
        hot155.push(0);
        hot155.push(-3);
        System.out.println(hot155.getMin());
        hot155.pop();
        System.out.println(hot155.top());
        System.out.println(hot155.getMin());
    }

    /**
     * 思路为用一个辅助栈存储当前当前栈的最小值
     * 时间复杂度O(1)，进栈、出栈、取栈顶都是O(1)
     * 空间复杂度O(n)，辅助栈空间为O(n)
     */
    // 正常栈
    Stack<Integer> commonStack;
    // 最小栈
    Stack<Integer> minStack;

    public hot155() {
        commonStack = new Stack<>();
        minStack = new Stack<>();
        // 为了避免第一个进栈元素没有比较的，初始化minStack(辅助栈永远比正常栈多一个元素)
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        int value = Math.min(val, minStack.peek());
        commonStack.push(val);
        minStack.push(value);
    }

    public void pop() {
        commonStack.pop();
        minStack.pop();
    }

    public int top() {
        return commonStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}