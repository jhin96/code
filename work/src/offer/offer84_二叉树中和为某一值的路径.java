package offer;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉树root和一个整数值 sum ，求该树有多少路径的的节点值之和等于 sum 。
 *
 * https://www.nowcoder.com/practice/965fef32cae14a17a8e86c76ffe3131f?tpId=13&tqId=2277604&sourceUrl=
 *
 */
public class offer84_二叉树中和为某一值的路径 {

    public int res = 0;

    /**
     * 前缀和
     *
     * @param root
     * @param sum
     * @return
     */
    public int FindPath (TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // 初始化前缀和map
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        helper(root, 0, sum, map);
        return res;
    }

    public void helper (TreeNode root, int pre, int sum, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        pre += root.val;
        res += map.getOrDefault(pre - sum, 0);
        map.put(pre, map.getOrDefault(pre, 0) + 1);
        helper(root.left, pre, sum, map);
        helper(root.right, pre, sum, map);
        map.put(pre, map.get(pre) - 1);
    }

    public int method1 (TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0, sum) + method1(root.left, sum) + method1(root.right, sum);
    }

    /**
     * 当前节点开始和为sum的数量
     *
     * @param root
     * @param cur
     * @param sum
     * @return
     */
    public int dfs(TreeNode root, int cur, int sum) {
        if (root == null) {
            return 0;
        }
        int path = 0;
        if (cur + root.val == sum) {
            path++;
        }
        return path + dfs(root.left, cur + root.val, sum) + dfs(root.right, cur + root.val, sum);
    }

}
