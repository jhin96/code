package newhot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class newhot17_电话号码的字母组合 {

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        Map<Character, String[]> map = new HashMap<>();
        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"g", "h", "i"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"m", "n", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "z"});
        List<String> res = new ArrayList<>();
        dfs(digits, res, "", map, 0);
        return res;
    }

    public void dfs (String digits, List<String> res, String s, Map<Character, String[]> map, int index) {
        if (s.length() == digits.length()) {
            res.add(s);
            return;
        }
        if (index >= digits.length()) {
            return;
        }
        String[] strArr = map.get(digits.charAt(index));
        for (int i = 0; i < strArr.length; i++) {
            s += strArr[i];
            // 这里是index+1
            dfs(digits, res, s, map, index + 1);
            s = s.substring(0, s.length() - 1);
        }
    }

}
