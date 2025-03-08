package leetcode100;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot17_电话号码的字母组合 {

    public static void main(String[] args) {
        hot17_电话号码的字母组合 hot17_电话号码的字母组合 = new hot17_电话号码的字母组合();
        List<String> strings = hot17_电话号码的字母组合.letterCombinations("23");
        System.out.println(strings);
    }

    /**
     * 回溯法枚举所有可能结果
     * 时间复杂度：O(3的m次方 * 4的n次方)，m是3个字母的数字个数，n是4个字母的数字个数，组合的次数就是次方数相乘
     * 空间复杂度：O(m + n)，m + n是总数字个数，递归栈空间
     *
     * @param digits
     * @return
     */
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
        dfs(digits, new StringBuilder(), res, map, 0);
        return res;
    }

    /**
     * index表示遍历到第几个元素了，然后每个元素都要从0开始
     *
     * @param digits
     * @param stb
     * @param res
     * @param map
     * @param index
     */
    public void dfs (String digits, StringBuilder stb, List<String> res, Map<Character, String[]> map, int index) {
        if (stb.length() == digits.length()) {
            res.add(stb.toString());
            return;
        }
        String[] strArray = map.get(digits.charAt(index));
        for (int i = 0; i < strArray.length; i++) {
            stb.append(strArray[i]);
            dfs(digits, stb, res, map, index + 1);
            stb.deleteCharAt(stb.length() - 1);
        }
    }

}
