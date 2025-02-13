package leetcode100;


import utils.TreeNode;

/**
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot124_二叉树中的最大路径和 {

    int max = Integer.MIN_VALUE;

    /**
     * 二叉树其实就是一个个子树构成，单个子树的最大路径有6种
     * ①根+左+右②根+左③根+右④根⑤左⑥右
     * 其中只有2、3、4可以和其他子树拼接，1、5、6不行（1会分叉，5、6会断）
     * 所以思路就是求可以拼接和不能拼接的最大值，dfs就行
     *
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    /**
     * 返回能和其他子树拼接的最大值
     *
     * @param root
     * @return
     */
    public int dfs(TreeNode root) {
        if (root == null) {
            // 不能用Integer.MIN_VALUE，因为节点可能有负数，会越界
            // 不能用0，因为父节点可能是负数，max之后会成0
            return -10000;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        // 要注意拼接的左、右并不是一个节点，而是包含了子树的！
        // 可以拼接的情况
        int canJoin = Math.max(root.val, Math.max(root.val + left, root.val + right));

        // 不能拼接的情况
        int cantJoin = Math.max(root.val + left + right, Math.max(left, right));

        max = Math.max(max, Math.max(canJoin, cantJoin));

        return canJoin;
    }

}