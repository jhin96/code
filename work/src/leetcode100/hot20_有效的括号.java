package leetcode100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * https://leetcode.cn/problems/valid-parentheses/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot20_有效的括号 {

    /**
     * 换种写法，为左括号时，相对的右括号进栈
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                // 右括号
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 栈，左括号进栈，右括号需要判断栈顶
     *
     * @param s
     * @return
     */
    public boolean method1(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                // 右括号
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    Character pop = stack.pop();
                    if (c == ')' && pop != '(') {
                        return false;
                    } else if (c == ']' && pop != '[') {
                        return false;
                    }else if (c == '}' && pop != '{') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 这种只能判断单个括号，([)]就不行
     *
     * @param s
     * @return
     */
    public boolean error(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        // 每一种括号都是左括号一直大于又括号
        Map<Character, Integer> map = new HashMap<>();
        map.put('(', 0);
        map.put('[', 0);
        map.put('{', 0);
        for (char c : s.toCharArray()) {
            // 左括号
            if (c == '(' || c == '[' || c == '{') {
                map.put(c, map.get(c) + 1);
            } else if (c == ')') {
                // 右括号
                if (map.get('(') <= 0) {
                    return false;
                } else {
                    map.put('(', map.get('(') - 1);
                }
            } else if (c == ']') {
                if (map.get('[') <= 0) {
                    return false;
                } else {
                    map.put('[', map.get('[') - 1);
                }
            }else if (c == '}') {
                if (map.get('{') <= 0) {
                    return false;
                } else {
                    map.put('{', map.get('{') - 1);
                }
            }
        }
        return map.get('(') == 0 && map.get('[') == 0 &&map.get('{') == 0;
    }

}
