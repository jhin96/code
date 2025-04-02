package newhot;

import utils.TreeNode;

import java.util.Stack;

public class newhot98_验证二叉搜索树 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 需要用long类型
        long pre = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                if (pre >= pop.val) {
                    return false;
                }
                pre = pop.val;
                root = pop.right;
            }
        }
        return true;
    }

    long pre = Long.MIN_VALUE;

    boolean res = true;

    public boolean mthod1(TreeNode root) {
        if (root == null) {
            return true;
        }
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre >= root.val) {
            res = false;
        }
        pre = root.val;
        dfs(root.right);
    }

}