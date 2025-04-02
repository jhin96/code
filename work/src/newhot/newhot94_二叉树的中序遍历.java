package newhot;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class newhot94_二叉树的中序遍历 {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                res.add(pop.val);
                root = pop.right;
            }
        }
        return res;
    }

    public List<Integer> res = new ArrayList<>();

    public List<Integer> method1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        method1(root.left);
        res.add(root.val);
        method1(root.right);
        return res;
    }

}