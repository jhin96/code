package leetcode100;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * https://leetcode.cn/problems/permutations/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot46_全排列 {

    public static void main(String[] args) {
        hot46_全排列 hot46_全排列 = new hot46_全排列();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = hot46_全排列.permute(nums);
    }

    /**
     * 回溯法经典问题
     * 时间复杂度：O(n * n!)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }

    public void dfs(int[] nums, boolean[] visit, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 使用过
            if (visit[i]) {
                continue;
            }
            list.add(nums[i]);
            visit[i] = true;
            dfs(nums, visit, list, res);
            list.remove(list.size() - 1);
            visit[i] = false;
        }
    }

}
