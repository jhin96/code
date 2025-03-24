package leetcode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * https://leetcode.cn/problems/pascals-triangle/description/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class hot118_杨辉三角 {

    /**
     * 更简洁的写法
     * 时间复杂度：O(n方)
     * 空间复杂度：O(1)
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        if (numRows < 1) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // 首尾单独处理
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(cur);
        }
        return res;
    }

    /**
     * 正常遍历
     * 时间复杂度：O(n方)
     * 空间复杂度：O(1)
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> method1(int numRows) {
        if (numRows < 1) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        // 提前将第一行初始化
        res.add(Arrays.asList(1));
        for (int i = 2; i <= numRows; i++) {
            // 获取上一层数据
            List<Integer> pre = res.get(i - 2);
            List<Integer> cur = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                int num = 0;
                // 左边元素只需要判断左边界
                if (j - 2 >= 0) {
                    num += pre.get(j - 2);
                }
                // 右边元素只需要判断右边界
                if (j - 1 <= i - 2) {
                    num += pre.get(j - 1);
                }
                cur.add(num);
            }
            res.add(cur);
        }
        return res;
    }

}
