package leetcode100;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 *
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class hot230_二叉搜索树中第K小的元素 {

    /**
     * 中序遍历的第k个元素
     * 时间复杂度：O(k)
     * 空间复杂度：O(h)，h为树的高度
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                // 出栈
                TreeNode pop = stack.pop();
                k--;
                if (k == 0) {
                    return pop.val;
                }
                root = pop.right;
            }
        }
        // 没有第k个元素
        return -1;
    }

    /**
     * 递归遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root
     * @param k
     * @return
     */
    public int method1(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res.get(k - 1);
    }

    public void dfs (TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }


}
