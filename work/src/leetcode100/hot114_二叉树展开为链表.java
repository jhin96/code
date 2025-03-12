package leetcode100;

import utils.TreeNode;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot114_二叉树展开为链表 {

    public static void main(String[] args) {
        hot114_二叉树展开为链表 hot114_二叉树展开为链表 = new hot114_二叉树展开为链表();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node1.right = node5;
        node5.right = node6;
        hot114_二叉树展开为链表.flatten(node1);
    }

    /**
     * dfs递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)，递归需要的栈空间
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root);
    }

    public TreeNode dfs (TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);
        // 找到左子树的最后一个节点
        if (left != null) {
            TreeNode tmp = left;
            while (tmp.right != null) {
                tmp = tmp.right;
            }
            root.right = left;
            tmp.right = right;
            // 需要将左节点断开
            root.left = null;
        }
        // 这里不需要加else root.right = right;(左边为空就不需要处理右节点) 但是加了好理解
        return root;
    }

}
