package newhot;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class newhot437_路径总和III {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int rootSum = dfs(root, 0, targetSum);
        return rootSum + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    public int dfs(TreeNode root, long cur,  int targetSum) {
        if (root == null) {
            return 0;
        }
        // 要用long类型，不然会超限
        long value = root.val + cur;
        // 从当前节点开始和为targetSum的个数
        int sum = value == targetSum ? 1 : 0;
        return sum + dfs(root.left, value, targetSum) + dfs(root.right, value, targetSum);
    }

    public int res = 0;

    public int method1(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        // 前缀和，需要初始化这个map
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        helper(root, 0L, targetSum, map);
        return res;
    }

    public void helper(TreeNode root, long pre, int targetSum, Map<Long, Integer> map) {
        if (root == null) {
            return;
        }
        pre += root.val;
        // 需要先更新res，先更新map的话pre就会影响当前节点了（如根节点是1，target是0）
        res += map.getOrDefault(pre - targetSum, 0);
        map.put(pre, map.getOrDefault(pre, 0) + 1);
        helper(root.left, pre, targetSum, map);
        helper(root.right, pre, targetSum, map);
        // 类似回溯，不能影响其他分支
        map.put(pre, map.get(pre) - 1);
    }

}