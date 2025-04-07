package offer;

import utils.TreeNode;

/**
 * 给定一棵二叉树(保证非空)以及这棵树上的两个节点对应的val值 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。
 *
 * https://www.nowcoder.com/practice/e0cc33a83afe4530bcec46eba3325116?tpId=13&tqId=1024325&sourceUrl=
 *
 */
public class offer86_在二叉树中找到两个节点的最近公共祖先 {

    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
       if (root == null) {
            return -1;
       }
       if (root.val == o1 || root.val == o2) {
           return root.val;
       }
        int left = lowestCommonAncestor(root.left, o1, o2);
        int right = lowestCommonAncestor(root.right, o1, o2);
       if (left == -1) {
           return right;
       }
       if (right == -1) {
           return left;
       }
       return root.val;
    }

}
