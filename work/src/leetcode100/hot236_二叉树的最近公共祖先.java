package leetcode100;

import utils.TreeNode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot236_二叉树的最近公共祖先 {

    /**
     * 只要求出2条路径，再求出2条路径上从根节点开始的最后一个重叠节点即可
     * 思想：（这么想好理解）
     * 如果p,q分别在当前节点的左子树和右子树上，那么root一定是最近的公共祖先
     * 如果p,q要么都在左子树上，要么都在右子树上，那么公共祖先一定是递归p,q返回路径上的一个。
     *
     * 时间复杂度：O(n) 最差情况递归遍历所有节点
     * 空间复杂度：O(n) 最差情况递归深度为n
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 只要当前根节点是p和q中的任意一个，就返回（因为不能比这个更深了，再深p和q中的一个就没了）
        // 其实就是找p和q
        if (root == null || root == p || root == q) {
            return root;
        }
        // 根节点不是p和q中的任意一个，那么就继续分别往左子树和右子树找p和q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p ,q);

        // 左子树没有p也没有q，就返回右子树的结果
        if (left == null) {
            return right;
        }
        // 右子树没有p也没有q就返回左子树的结果
        if (right == null) {
            return left;
        }

        // 左右子树都找到p和q了，那就说明p和q分别在左右两个子树上，所以此时的最近公共祖先就是root
        return root;
    }

}
