package suanfa;

import java.util.ArrayList;
import java.util.List;

public class huisu_全排列 {

    List<List<Integer>> ans = new ArrayList<>();

    /**
     * 全排列问题，经典回溯法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        // 用于记录当前元素访问过没有
        boolean[] visit = new boolean[nums.length];
        dfs(nums, visit, new ArrayList<>());
        return ans;
    }

    /**
     * dfs
     *
     * @param nums num数组
     * @param visit 访问标签
     * @param res 记录结果子list
     */
    public void dfs(int[] nums, boolean[] visit, List<Integer> res) {
        // 结束条件
        if (res.size() == nums.length) {
            ans.add(new ArrayList<>(res));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i]) {
                continue;
            }
            res.add(nums[i]);
            visit[i] = true;
            dfs(nums, visit, res);
            // 还原状态
            visit[i] = false;
            // 当前结果清理
            res.remove(res.size() - 1);
        }
    }

}
