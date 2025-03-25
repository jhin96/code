package newhot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class newhot49_字母异位词分组 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length < 1) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        // 转化为字符对应的个数形式，单纯的数字不行，因为101这种会有两种区分方法
        for (String s : strs) {
            int[] arr = new int[26];
            for (char c : s.toCharArray()) {
                arr[c - 'a']++;
            }
            StringBuilder stb = new StringBuilder();
            for (int i : arr) {
                char ch = (char) ('a' + i);
                stb.append(ch + i);
            }
            String key = stb.toString();
            List<String> stringList = map.getOrDefault(key, new ArrayList<>());
            stringList.add(s);
            map.put(key, stringList);
        }
        return new ArrayList<>(map.values());
    }

}
