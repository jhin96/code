package offer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的 min 函数，输入操作时保证 pop、top 和 min 函数操作时，栈中一定有元素。
 *
 * https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=13&tqId=23268&sourceUrl=
 *
 */
public class offer30_包含min函数的栈 {

    Stack<Integer> stack = new Stack<Integer>();
    // 维护一个递减栈
    Stack<Integer> minStack = new Stack<Integer>();

    public void push(int node) {
        stack.push(node);
        if (minStack.isEmpty() || minStack.peek() >= node) {
            minStack.push(node);
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

    public int min() {
        return minStack.peek();
    }

}
