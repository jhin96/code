package leetcode100;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * https://leetcode.cn/problems/generate-parentheses/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot22_括号生成 {

    public static void main(String[] args) {
        hot22_括号生成 hot22_括号生成 = new hot22_括号生成();
        hot22_括号生成.generateParenthesis(3);
    }

    /**
     * 回溯，特征就是：右括号不能比左括号多
     * 时间复杂度：O(4的n次方 / 根号n)
     * 空间复杂度：O(n)，递归栈深度
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        dfs(new StringBuilder(), res, 0, 0, n);
        return res;
    }

    public void dfs(StringBuilder str, List<String> res, int leftNum, int rightNum, int n) {
        // 这里不用考虑大于n的情况，因为只有小于n还会执行dfs
        if (leftNum == n && rightNum == n) {
            res.add(str.toString());
            return;
        }
        // 右括号不能多于左括号
        if (rightNum > leftNum) {
            return;
        }
        if (leftNum < n) {
            dfs(str.append("("), res, leftNum + 1, rightNum, n);
            str.deleteCharAt(str.length() - 1);
        }
        if (rightNum < n) {
            dfs(str.append(")"), res, leftNum, rightNum + 1, n);
            str.deleteCharAt(str.length() - 1);
        }
    }

}
