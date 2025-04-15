package newhot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class newhot763_划分字母区间 {

    public List<Integer> partitionLabels(String s) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }
        Map<Character, Integer> map = new HashMap<>();
        // 记录每个元素出现的最远距离
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int max = map.get(s.charAt(i));
            for (int j = i; j <= max; j++) {
                max = Math.max(max, map.get(s.charAt(j)));
            }
            res.add(max - i + 1);
            // 不需要+1，因为for循环会+1
            i = max;
        }
        return res;
    }

}
