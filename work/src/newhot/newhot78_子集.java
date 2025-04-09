package newhot;

import java.util.ArrayList;
import java.util.List;

public class newhot78_子集 {

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new ArrayList<>(), 0);
        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> tmp, int index) {
        res.add(new ArrayList<>(tmp));
        for (int i = index; i < nums.length; i++) {
            tmp.add(nums[i]);
            // 这里是i+1，有的地方是index+1
            dfs(nums, res, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

}
