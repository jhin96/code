package leetcode100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。
 * 你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。。
 *
 * https://leetcode.cn/problems/combination-sum/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot39_组合总和 {

    public static void main(String[] args) {
        hot39_组合总和 hot39_组合总和 = new hot39_组合总和();
        hot39_组合总和.combinationSum(new int[]{2, 3, 6, 7}, 7);
    }

    /**
     * 回溯法
     * 时间复杂度：O(s)，s是所有可能性和，最大为n * 2的n次方
     * 空间复杂度：O(target)，最多需要target的栈空间
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length < 1) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, 0, res, new ArrayList<>());
        return res;
    }

    /**
     * index表示当前遍历的位置
     *
     * @param candidates
     * @param target
     * @param index
     * @param current
     * @param res
     * @param curList
     */
    public void dfs(int[] candidates, int target, int index, int current, List<List<Integer>> res, List<Integer> curList) {
        if (target == current) {
            res.add(new ArrayList<>(curList));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            // 当前元素大于剩余值
            if (candidates[i] > target - current) {
                continue;
            }
            curList.add(candidates[i]);
            // 这次需要从i开始，不然就会有重复解
            dfs(candidates, target, i, current + candidates[i], res, curList);
            curList.remove(curList.size() - 1);
        }
    }

}
