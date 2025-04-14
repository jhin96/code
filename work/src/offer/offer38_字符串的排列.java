package offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 输入一个长度为 n 字符串，打印出该字符串中字符的所有排列，你可以以任意顺序返回这个字符串数组。
 *
 * https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7?tpId=13&tqId=23291&sourceUrl=
 *
 */
public class offer38_字符串的排列 {

    public ArrayList<String> Permutation (String str) {
        if (str == null || str.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<String> res = new ArrayList<>();
        dfs(str, new boolean[str.length()], res, new StringBuilder());
        return res;
    }

    public void dfs (String str, boolean[] visit, ArrayList<String> res, StringBuilder builder) {
        if (builder.length() == str.length()) {
            res.add(builder.toString());
            return;
        }
        // 记录当前轮次出现过那些元素（相当于这个for循环只处理这一位），只需要在for之前初始化
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (visit[i] || set.contains(str.charAt(i))) {
                continue;
            }
            set.add(str.charAt(i));
            builder.append(str.charAt(i));
            visit[i] = true;
            dfs(str, visit, res, builder);
            builder.deleteCharAt(builder.length() - 1);
            visit[i] = false;
        }
    }

}
