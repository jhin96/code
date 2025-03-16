package leetcode100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * https://leetcode.cn/problems/subsets/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot78_子集 {

    public static void main(String[] args) {
        hot78_子集 hot78_子集 = new hot78_子集();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> subsets = hot78_子集.subsets(nums);
        System.out.println();
    }

    /**
     * 回溯
     * 时间复杂度：O(n * 2的n次方)，2的n次方为子集个数，复制数组需要n的时间（最大长度为n）
     * 空间复杂度：O(n)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public void dfs (List<List<Integer>> res, List<Integer> tmp, int[] nums, int index) {
        // 记录结果
        res.add(new ArrayList<>(tmp));
        if (index >= nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            tmp.add(nums[i]);
            // 这里注意要从i+1开始，而不是index+1
            dfs(res, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

}
