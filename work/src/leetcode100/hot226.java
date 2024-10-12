package leetcode100;

import utils.TreeNode;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 *https://leetcode.cn/problems/invert-binary-tree/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot226 {

    /**
     * 递归翻转
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        // 需要用tmp保存下来，不然影响后面的结果
        TreeNode tmpLeft = invertTree(root.right);
        TreeNode tmpRight = invertTree(root.left);
        root.left = tmpLeft;
        root.right = tmpRight;
        return root;
    }

}
