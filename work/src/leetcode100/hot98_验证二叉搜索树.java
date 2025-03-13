package leetcode100;


import utils.TreeNode;

import java.util.Stack;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * https://leetcode.cn/problems/validate-binary-search-tree/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot98_验证二叉搜索树 {

    Long pre = Long.MIN_VALUE;

    /**
     * 递归中序遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (root.val <= pre || !left) {
            return false;
        }
        pre = (long)root.val;
        return isValidBST(root.right);
    }

    /**
     * 中序遍历，用一个pre记录上一个节点值
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)，退化为链表为n
     *
     * @param root
     * @return
     */
    public boolean method1(TreeNode root) {
        if (root == null) {
            return true;
        }
        long pre = (long)Integer.MIN_VALUE - 1;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                // !stack.isEmpty()
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

    /**
     * 递归
     * 这样不行，因为只能判断各个子树，有些叶子节点没办法跟祖先节点比较
     *
     * @param root
     * @return
     */
    public boolean error(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean valid = true;
        if (root.left != null) {
            valid = root.val > root.left.val;
        }
        if (root.right != null) {
            valid = valid && root.val < root.right.val;
        }
        return valid && error(root.left) && error(root.right);
    }

}
