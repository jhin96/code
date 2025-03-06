package leetcode100;


import utils.TreeNode;

import java.util.Map;
import java.util.logging.Level;

/**
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * 提醒一下，二叉搜索树满足下列约束条件：
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 *
 * https://leetcode.cn/problems/convert-bst-to-greater-tree/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot538_把二叉搜索树转换为累加树 {

    int sum = 0;

    /**
     * 反向中序遍历，用全局变量记录当前累加和
     * 时间复杂度：O(n)
     * 空间复杂度：O(logn)，最坏O(n)
     *
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
    }


    public TreeNode method1(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root, 0);
        return root;
    }

    public int dfs(TreeNode root, int val) {
        if (root == null) {
            // 返回0会导致之前的结果没有
            return val;
        }
        int right = dfs(root.right, val);
        root.val += right;
        // 直接将left返回，因为left > val
        return dfs(root.left, root.val);
    }

}
