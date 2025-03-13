package leetcode100;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder是二叉树的先序遍历，inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot105_从前序与中序遍历序列构造二叉树 {

    /**
     * dfs构建子树
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)，map占用空间为n，递归栈空间最大也是n
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length < 1) {
            return null;
        }
        // 记录值与下标的关系
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return dfs(preorder, inorder, inorderMap, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, Map<Integer, Integer> inorderMap, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = inorderMap.get(preorder[preStart]);
        // 注意这里的索引
        root.left = dfs(preorder, inorder, inorderMap, preStart + 1, preStart + index - inStart, inStart, index - 1);
        root.right = dfs(preorder, inorder, inorderMap, preStart + index - inStart + 1, preEnd, index + 1, inEnd);
        return root;
    }

}
