package newhot;

import java.util.ArrayList;
import java.util.List;

public class newhot39_组合总和 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length < 1) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        // candidates都是正数
        dfs(candidates, target, 0, res, new ArrayList<>(), 0);
        return res;
    }

    public void dfs (int[] candidates, int target, int current, List<List<Integer>> res, List<Integer> tmp, int index) {
        if (current == target) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (current + candidates[i] > target) {
                continue;
            }
            tmp.add(candidates[i]);
            dfs(candidates, target, current + candidates[i], res, tmp, i);
            tmp.remove(tmp.size() - 1);
        }

    }

}
