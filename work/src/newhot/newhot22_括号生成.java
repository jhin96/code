package newhot;

import java.util.ArrayList;
import java.util.List;

public class newhot22_括号生成 {

    public List<String> generateParenthesis(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        dfs(res, n, 0, 0, new StringBuilder());
        return res;
    }

    public void dfs (List<String> res, int n, int leftNum, int rightNum, StringBuilder tmp) {
        if (leftNum == n && rightNum == n) {
            res.add(tmp.toString());
            return;
        }
        if (leftNum > n || rightNum > n || rightNum > leftNum) {
            return;
        }
        tmp.append("(");
        dfs(res, n, leftNum + 1, rightNum, tmp);
        tmp.deleteCharAt(tmp.length() - 1);
        tmp.append(")");
        dfs(res, n, leftNum, rightNum + 1, tmp);
        tmp.deleteCharAt(tmp.length() - 1);
    }

}
