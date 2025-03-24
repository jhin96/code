package leetcode100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 例如，字符串 "ababcc" 能够被分为 ["abab", "cc"]，但类似 ["aba", "bcc"] 或 ["ab", "ab", "cc"] 的划分是非法的。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * 返回一个表示每个字符串片段的长度的列表。
 *
 * https://leetcode.cn/problems/partition-labels/description/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class hot763_划分字母区间 {

    public static void main(String[] args) {
        hot763_划分字母区间 func = new hot763_划分字母区间();
        List<Integer> integers = func.partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(integers);
    }

    /**
     * method1一个思想，动态更新max，但是不需要储存结果的临时list
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }
        // 记录每个元素出现的最大索引
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = Math.max(map.getOrDefault(c, 0), i);
            map.put(c, index);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int max = map.get(s.charAt(i));
            for (int j = i; j <= max; j++) {
               max = Math.max(max, map.get(s.charAt(j)));
            }
            // 此时遍历完第一组
            res.add(max - i + 1);
            i = max;
        }
        return res;
    }

    /**
     * 记录每个元素最远出现的index，并遍历这区间所有元素，然后动态更新本次遍历的终点
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param s
     * @return
     */
    public List<Integer> method1(String s) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }
        // 记录每个元素出现的最大索引
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = Math.max(map.getOrDefault(c, 0), i);
            map.put(c, index);
        }
        // 记录分界点索引，需要添加0便于计算
        List<Integer> indexList = new ArrayList<>();
        indexList.add(0);
        // 记录当前遍历字符位置
        int index = 0;
        while (index < s.length()) {
            int end = map.get(s.charAt(index));
            // 遍历这个区间的所有元素
            while (index <= end) {
                // 更新end，需要保证到每个元素的最大位置
                end = Math.max(end, map.get(s.charAt(index)));
                index++;
            }
            // 此时index到了下个区间的第一个元素，这个区间所有的元素都遍历完成了
            indexList.add(index);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < indexList.size() - 1; i++) {
            res.add(indexList.get(i + 1) - indexList.get(i));
        }
        return res;
    }

}
