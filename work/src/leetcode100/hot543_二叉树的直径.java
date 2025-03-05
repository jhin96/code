package leetcode100;

import utils.TreeNode;

/**
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 *
 * https://leetcode.cn/problems/diameter-of-binary-tree/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot543_二叉树的直径 {

    public static void main(String[] args) {
        hot543_二叉树的直径 func = new hot543_二叉树的直径();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        func.diameterOfBinaryTree(root);
    }

    public int res = 0;

    /**
     * 二叉树的直径相当于左右子树深度相加
     * 时间复杂度：O(n)
     * 空间复杂度：O(h)，最坏情况下O(n)
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return res;
    }

    public int dfs (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res, left + right);
        // 相当于无子节点的深度为1
        return Math.max(left, right) + 1;
    }

}
