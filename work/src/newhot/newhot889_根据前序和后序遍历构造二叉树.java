package newhot;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class newhot889_根据前序和后序遍历构造二叉树 {

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if (preorder == null || postorder == null || preorder.length < 1 || postorder.length < 1) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return dfs(preorder, postorder, map, 0, preorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode dfs(int[] preorder, int[] postorder, Map<Integer, Integer> postorderMap, int startPre, int endPre, int startPost, int endPost) {
        if (startPre > endPre || startPost > endPost) {
            return null;
        }
        // 不加这个判断，下面startPre + 1可能越界
        if (startPre == endPre) {
            return new TreeNode(preorder[startPre]);
        }
        // 前序遍历的第二个节点，是后续遍历左子树的最右一个节点
        int m = postorderMap.get(preorder[startPre + 1]);
        TreeNode root = new TreeNode(preorder[startPre]);
        root.left = dfs(preorder, postorder, postorderMap, startPre + 1, startPre + m - startPost + 1, startPost, m);
        root.right = dfs(preorder, postorder, postorderMap, startPre + m - startPost + 2, endPre, m + 1, endPost - 1);
        return root;
    }

}