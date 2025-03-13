package leetcode100;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 二叉树的 最大深度是指从根节点到最远叶子节点的最长路径上的节点数。
 *
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot104_二叉树的最大深度 {

    /**
     * dfs
     * 时间复杂度：O(n)，每个节点都需要遍历
     * 空间复杂度：O(h)，平均为logn，最差n
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

}
