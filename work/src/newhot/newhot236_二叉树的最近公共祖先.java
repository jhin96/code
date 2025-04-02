package newhot;

import utils.TreeNode;

public class newhot236_二叉树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        // 递归到其中一个节点为root时返回root
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 都不为空说明root就是最近根节点
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

}
