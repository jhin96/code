package newhot;

import utils.TreeNode;

public class newhot543_二叉树的直径 {

    public int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 直径就是左右子树的最大深度相加
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 直径就是左右子树的最大深度相加
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res, left + right);
        // 相当于叶子结点的值为1
        return Math.max(left, right) + 1;
    }

}