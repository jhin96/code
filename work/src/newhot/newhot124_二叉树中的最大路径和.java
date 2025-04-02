package newhot;

import utils.TreeNode;

public class newhot124_二叉树中的最大路径和 {

    public long res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return (int)res;
    }

    public long dfs(TreeNode root) {
        if (root == null) {
            // 返回0的话树都是负数就不对了，返回minvalue碰到负数会越界
            return Integer.MIN_VALUE;
        }
        long left = dfs(root.left);
        long right = dfs(root.right);
        // 可拼接
        long canJoin = Math.max(Math.max(left, right) + root.val, root.val);
        // 不可拼接
        long cantJoin = Math.max(root.val + left + right, Math.max(left, right));
        // 更新res
        res = Math.max(res, Math.max(canJoin, cantJoin));
        // 返回当前节点可拼接的最大路径
        return canJoin;
    }

}
