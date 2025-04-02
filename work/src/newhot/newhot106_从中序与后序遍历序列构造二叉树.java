package newhot;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class newhot106_从中序与后序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length < 1 || postorder.length < 1) {
            return null;
        }
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return dfs(inorder, postorder, inorderMap, 0, inorder.length - 1, 0 , postorder.length - 1);
    }

    public TreeNode dfs(int[] inorder, int[] postorder, Map<Integer, Integer> inorderMap, int startIn, int endIn, int startPost, int endPost) {
        if (startIn > endIn || startPost > endPost) {
            return null;
        }
        int m = inorderMap.get(postorder[endPost]);
        // 根节点为后序遍历的最后一个
        TreeNode root = new TreeNode(postorder[endPost]);
        root.left = dfs(inorder, postorder, inorderMap,startIn, m - 1, startPost, startPost + m - startIn - 1);
        root.right = dfs(inorder, postorder, inorderMap, m + 1, endIn, startPost + m - startIn, endPost - 1);
        return root;
    }

}