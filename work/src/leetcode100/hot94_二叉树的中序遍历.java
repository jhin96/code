package leetcode100;


import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot94_二叉树的中序遍历 {

    /**
     * 借助一个栈遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)，树退化成链表
     *
     * @param root
     * @return
     */
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

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> method1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    public void dfs (TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }

}
