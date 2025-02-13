package tree;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class buildTree_前序和后序构建二叉树 {

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> postMap = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            postMap.put(postorder[i], i);
        }
        return dfs(preorder, postMap, 0, preorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode dfs(int[] preorder, Map<Integer, Integer> postMap, int preL, int preR, int postL, int postR) {
        if (preL > preR || postL > postR) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preL]);
        // 这里不判断的话，下一步pre + 1就可能越界
        if (preL == preR) {
            return root;
        }
        // preL + 1为左子树第一个节点，在后序中是左子树最后遍历的，可算出长度
        Integer m = postMap.get(preorder[preL + 1]);
        // 左子树
        root.left = dfs(preorder, postMap, preL + 1, preL + m - postL + 1, postL, m);
        // 右子树
        root.right = dfs(preorder, postMap, preL + m - postL + 2, preR, m + 1, postR - 1);
        return root;
    }

}
