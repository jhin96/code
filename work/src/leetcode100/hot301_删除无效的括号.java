package leetcode100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 *
 * https://leetcode.cn/problems/remove-invalid-parentheses/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class hot301_删除无效的括号 {

    /**
     * 这类题目只能是回溯 + 剪枝
     * 遍历一遍(和)数量得出需要删除两种括号数量的数量，最后判断是不是合法括号
     * 时间复杂度：O(n * 2的n次方) 一个字符串有2的n次方个子串，判断时间为n
     * 空间复杂度：O(n)，最大栈深度
     *
     * @param s
     * @return
     */
    public List<String> removeInvalidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }
        // 记录需要删除的2种括号数量，这个时候就是最少需要删除的数量
        int removeLeft = 0;
        int removeRight = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                removeLeft++;
            } else if (c == ')') {
                // 可能有其他的字符，比如a
                // 只能用右括号消除左括号
                if (removeLeft > 0) {
                    removeLeft--;
                } else {
                    removeRight++;
                }
            }
        }
        List<String> res = new ArrayList<>();
        dfs(s, 0, removeLeft, removeRight, res);
        return res;
    }

    /**
     * 以index为起点遍历整个字符串
     * 后续的遍历也是在index的基础上
     *
     * @param s
     * @param index
     * @param removeLeft
     * @param removeRight
     * @param res
     */
    public void dfs(String s, int index, int removeLeft, int removeRight, List<String> res) {
        if (removeLeft == 0 && removeRight == 0) {
            if (valid(s)) {
                res.add(s);
            }
            return;
        }

        for (int i = index; i < s.length(); i++) {
            // 剪枝,((()删除前3个括号得到的结果是一样的
            if (i != index && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            // 删除这个左括号
            if (removeLeft > 0 && s.charAt(i) == '(') {
                // 只是将i处的字符删掉
                // 这里是i而不是i + 1，因为删了一个元素，后面的元素往前移了（会一直删第一个元素，直到进入了第二个for循环）
                dfs(s.substring(0, i) + s.substring(i + 1), i, removeLeft - 1, removeRight, res);
            }
            // 删除这个右括号
            if (removeRight > 0 && s.charAt(i) == ')') {
                dfs(s.substring(0, i) + s.substring(i + 1), i, removeLeft, removeRight - 1, res);
            }
        }
    }

    /**
     * 判断是不是合法括号
     * 用右括号消除左括号
     *
     * @param s
     * @return
     */
    public boolean valid(String s) {
        int i = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                i++;
            } else if (c == ')') {
                i--;
            }
            if (i < 0) {
                return false;
            }
        }
        return i == 0;
    }

}
