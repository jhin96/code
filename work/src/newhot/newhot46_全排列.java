package newhot;

import java.util.ArrayList;
import java.util.List;

public class newhot46_全排列 {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new boolean[nums.length], res, new ArrayList<>());
        return res;
    }

    public void dfs (int[] nums, boolean[] visit, List<List<Integer>> res, List<Integer> tmp) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i]) {
                continue;
            }
            tmp.add(nums[i]);
            visit[i] = true;
            dfs(nums, visit, res, tmp);
            visit[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }

}
