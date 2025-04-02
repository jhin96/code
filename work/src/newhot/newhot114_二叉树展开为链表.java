package newhot;

import utils.TreeNode;

public class newhot114_二叉树展开为链表 {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root);
    }

    public TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 递归处理左右节点
        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);
        TreeNode tmp = left;
        if (tmp != null) {
            // 找到左子树的最右节点
            while (tmp.right != null) {
                tmp = tmp.right;
            }
            // 拼接
            root.left = null;
            root.right = left;
            tmp.right = right;
        }
        return root;
    }

}