package offer;


import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 *
 * https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&tqId=23290&sourceUrl=
 *
 */
public class offer31_栈的压入弹出序列 {

    /**
     * 用一个辅助栈，入栈后判断是否需要出栈
     *
     * @param pushV
     * @param popV
     * @return
     */
    public boolean IsPopOrder (int[] pushV, int[] popV) {
        Stack<Integer> stack = new Stack<>();
        // 出栈序列索引
        int index = 0;
        for (int i = 0; i < pushV.length; i++) {
            stack.push(pushV[i]);
            // 判断能不能出栈
            while (!stack.isEmpty() && stack.peek() == popV[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

}
