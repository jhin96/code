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
     * 时间复杂度：O(n)，二叉树节点数量
     * 空间复杂度：O(n)，由递归栈深度决定，最坏情况为链状O(n)，平均情况下为二叉树的高度与节点个数为对数关系，即O(logN)
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
