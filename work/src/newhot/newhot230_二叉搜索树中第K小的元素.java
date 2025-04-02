package newhot;

import utils.TreeNode;

import java.util.Stack;

public class newhot230_二叉搜索树中第K小的元素 {

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                k--;
                if (k == 0) {
                    return pop.val;
                }
                root = pop.right;
            }
        }
        return -1;
    }

}