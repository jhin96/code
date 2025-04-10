package newhot;


import java.util.ArrayList;
import java.util.List;

public class newhot131_分割回文串 {

    public List<List<String>> partition(String s) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }
        List<List<String>> res = new ArrayList<>();
        dfs(s, res, new ArrayList<>(), 0);
        return res;
    }

    public void dfs (String s, List<List<String>> res, List<String> tmp, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        List<Integer> indexList = getIndex(s, index);
        for (int i : indexList) {
            tmp.add(s.substring(index, i + 1));
            dfs(s, res, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    /**
     * 从start开始，回文串的结束索引
     *
     * @param s
     * @param start
     * @return
     */
    public List<Integer> getIndex(String s, int start) {
        List<Integer> res = new ArrayList<>();
        for (int i = start; i < s.length(); i++) {
            if (valid(s.substring(start, i + 1))) {
                res.add(i);
            }
        }
        return res;
    }

    public boolean valid(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
