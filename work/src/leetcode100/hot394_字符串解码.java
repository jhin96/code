package leetcode100;

import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * https://leetcode.cn/problems/decode-string/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class hot394_字符串解码 {

    public static void main(String[] args) {
        hot394_字符串解码 hot394_字符串解码 = new hot394_字符串解码();
        System.out.println(hot394_字符串解码.decodeString("abc3[cd]xyz"));
    }

    /**
     * 两个辅助栈解决问题，一个存储数字，一个存储字符，注意答案会在遍历过程中更新
     * 时间复杂度O(n)，一次遍历
     * 空间复杂度O(n)，极限情况下需要栈深度为n
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        // 最后结果，但是可以用于存储临时字符
        StringBuilder builder = new StringBuilder();
        int num = 0;
        // 存储数字
        Stack<Integer> numStack = new Stack<>();
        // 存储字符串
        Stack<String> charStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                // 将当前结果暂存，数字暂存并初始化
                numStack.push(num);
                charStack.push(builder.toString());
                num = 0;
                builder = new StringBuilder();
            } else if (c == ']') {
                // 此时当前临时字符串 = pop + count * builder
                int count = numStack.pop();
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    tmp.append(builder);
                }
                builder = new StringBuilder(charStack.pop() + tmp.toString());
            } else if (c >= 'a' && c <= 'z') {
                // 字符
                builder.append(c);
            } else {
                // 数字
                num = num * 10 + c - '0';
            }
        }
        return builder.toString();
    }
}
