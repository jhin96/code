package offer;

import utils.TreeNode;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * https://www.nowcoder.com/practice/d9820119321945f588ed6a26f0a6991f?tpId=13&tqId=2290592&sourceUrl=
 *
 */
public class offer68_二叉搜索树的最近公共祖先 {

    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        if (root == null) {
            return -1;
        }
        while (true) {
            // 都在左子树
            if (p < root.val && q < root.val) {
                root = root.left;
            } else if (p > root.val && q > root.val) {
                // 都在右子树
                root = root.right;
            } else {
                // 剩余情况都是返回root
                return root.val;
            }
        }
    }

}
