package newhot;


import java.util.Stack;

public class newhot394_字符串解码 {

    public String decodeString(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        int num = 0;
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                // 存储数字
                numStack.push(num);
                num = 0;
                // 存储字符串
                strStack.push(builder.toString());
                builder = new StringBuilder();
            } else if (c ==']') {
                Integer count = numStack.pop();
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    tmp.append(builder);
                }
                builder = new StringBuilder(strStack.pop() + tmp);
            } else if (c >= 'a' && c <= 'z') {
                builder.append(c);
            } else {
                num = num * 10 + c - '0';
            }
        }
        return builder.toString();
    }
    
}
