package offer;

import utils.TreeNode;

import java.util.Map;

/**
 * 输入一棵节点数为 n 二叉树，判断该二叉树是否是平衡二叉树。
 *
 * https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222?tpId=13&tqId=23250&sourceUrl=
 *
 */
public class offer79_判断是不是平衡二叉树 {

    boolean res = true;

    public boolean IsBalanced_Solution (TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        helper(pRoot);
        return res;
    }

    /**
     * 递归求深度的过程中更新res
     *
     * @param pRoot
     * @return
     */
    public int helper (TreeNode pRoot) {
        if (pRoot == null) {
            return 0;
        }
        int left = helper(pRoot.left);
        int right = helper(pRoot.right);
        if (Math.abs(left - right) > 1) {
            res = false;
        }
        return Math.max(left, right) + 1;
    }

    /**
     * 求深度，并遍历每个节点
     *
     * @param pRoot
     * @return
     */
    public boolean method1 (TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        int left = getDepth(pRoot.left);
        int right = getDepth(pRoot.right);
        int value = left >= right ? left - right : right - left;
        return value <= 1 && method1(pRoot.left) && method1(pRoot.right);
    }

    /**
     * 获取当前节点深度
     *
     * @param pRoot
     * @return
     */
    public int getDepth (TreeNode pRoot) {
        if (pRoot == null) {
            return 0;
        }
        return Math.max(getDepth(pRoot.left), getDepth(pRoot.right)) + 1;
    }

}
