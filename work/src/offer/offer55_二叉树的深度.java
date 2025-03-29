package offer;

import utils.TreeNode;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度，根节点的深度视为 1 。
 *
 * https://www.nowcoder.com/practice/435fb86331474282a3499955f0a41e8b?tpId=13&tqId=23294&sourceUrl=
 *
 */
public class offer55_二叉树的深度 {

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return Math.max(left, right) + 1;
    }

}
