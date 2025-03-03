package leetcode100;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 * https://leetcode.cn/problems/group-anagrams/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot49_字母异位词分组 {

    public static void main(String[] args) {
        hot49_字母异位词分组 hot49_字母异位词分组 = new hot49_字母异位词分组();
        hot49_字母异位词分组.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    /**
     * 类似int[26]的做法比较，但是需要注意Integer[]不能作为map的key
     * 还有种方法就是array是charArray，Arrays.sort(array);String key = new String(array);
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length < 1) {
            return new ArrayList<>();
        }

        // Integer[]作为key的话，containsKey会一直返回false
        Map<List<Integer>, List<String>> map = new HashMap<>();
        for (String s : strs) {
            List<Integer> intList = new ArrayList<>(Collections.nCopies(26, 0));
            for (char c : s.toCharArray()) {
                intList.set(c - 'a', intList.get(c - 'a') + 1);
            }
            if (map.containsKey(intList)) {
                map.get(intList).add(s);
            } else {
                List<String> arrayList = new ArrayList<>();
                arrayList.add(s);
                map.put(intList, arrayList);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }

    /**
     * 时间复杂度：O(n(k+∣Σ∣))，n为strs长度，k为单个str最大长度，Σ=26
     * 空间复杂度：O(n(k+∣Σ∣))
     *
     * @param strs
     * @return
     */
    public List<List<String>> method1(String[] strs) {
        if (strs == null || strs.length < 1) {
            return new ArrayList<>();
        }

        // key是转换过，aab是a2b1
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] intArr = new int[26];
            for (char c : str.toCharArray()) {
                intArr[c - 'a']++;
            }
            StringBuilder stb = new StringBuilder();
            // 转化为key
            for (int i = 0; i < 26; i++) {
                stb.append((char)(i - 'a'));
                stb.append(intArr[i]);
            }
            List<String> list = map.getOrDefault(stb.toString(), new ArrayList<>());
            list.add(str);
            map.put(stb.toString(), list);
        }
        return new ArrayList<>(map.values());
    }

}
