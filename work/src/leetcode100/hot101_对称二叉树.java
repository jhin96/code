package leetcode100;

import utils.TreeNode;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * https://leetcode.cn/problems/symmetric-tree/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot101_对称二叉树 {

    /**
     * 递归比较左、右子树
     * 时间复杂度：O(n)，最多n/2次递归
     * 空间复杂度：O(h)，递归栈的深度，退化为链表为O(n)
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.val == node2.val && helper(node1.left, node2.right) && helper(node1.right, node2.left);
    }

}
