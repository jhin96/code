package newhot;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class newhot105_从前序与中序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length < 1 || inorder.length < 1) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, inorder, map, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, Map<Integer, Integer> inorderMap, int startPre, int endPre, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        int m = inorderMap.get(preorder[startPre]);
        TreeNode root = new TreeNode(preorder[startPre]);
        root.left = dfs(preorder, inorder, inorderMap, startPre + 1, startPre + m - startIn, startIn, m - 1);
        root.right = dfs(preorder, inorder, inorderMap, startPre + 1 + m - startIn, endPre, m + 1, endIn);
        return root;
    }

}