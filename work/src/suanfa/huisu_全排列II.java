package suanfa;

import java.util.*;

public class huisu_全排列II {

    List<List<Integer>> ans = new ArrayList<>();

    /**
     * 全排列问题，但是有重复元素，并且返回值不允许重复
     * 需要剪枝，就是某一轮中，同一元素num只能被选择一次
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        dfs(nums, new boolean[nums.length], new ArrayList<>());
        return ans;
    }

    public void dfs(int[] nums, boolean[] visit, List<Integer> res) {
        if (res.size() == nums.length) {
            ans.add(new ArrayList<>(res));
            return;
        }
        // 记录当前轮次已经访问的元素做剪枝，不能用全局map记录索引 - 元素，因为213遍历过的话312就直接跳过了
        HashSet<Integer> set = new HashSet<>();
        // 这里其实可以理解为上次的轮次是i-1，这个for循环的任务遍历的就是i轮次的所有可能num
        for (int i = 0; i < nums.length; i++) {
            // 访问过或者当前轮次已经遍历过这个元素
            if (visit[i] || set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            res.add(nums[i]);
            visit[i] = true;
            dfs(nums, visit, res);
            visit[i] = false;
            res.remove(res.size() - 1);
        }
    }

}
