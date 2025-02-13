package tree;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class buildTree_前序和中序构建二叉树 {

    /**
     * 没有重复元素
     * 前序遍历的第一个节点就是根节点
     * 找到这个根节点在中序遍历中的位置，左边就是左子树，右边就是右子树，得到了左右子树的长度
     * 根据左右子树的长度，就可推出左右子树在前序遍历中的区间
     * 这样就能把根-左-右这三部分分开来，然后分治处理左、右子树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return dfs(preorder, inorderMap, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * 注意计算区间的时候，基准为pre和in本身，不能混淆
     *
     * @param preorde 整个树前序遍历的数组
     * @param inorderMap 中序遍历节点-索引map
     * @param preL 前序起点索引
     * @param preR 前序终点索引
     * @param inL 中序起点索引
     * @param inR 中序终点索引
     * @return
     */
    public TreeNode dfs(int[] preorde, Map<Integer, Integer> inorderMap, int preL, int preR, int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }
        TreeNode root = new TreeNode(preorde[preL]);
        // 根节点在中序遍历的索引
        Integer m = inorderMap.get(preorde[preL]);
        // 左子树
        root.left = dfs(preorde, inorderMap, preL + 1, preL + m - inL, inL, m - 1);
        // 右子树
        root.right = dfs(preorde, inorderMap, preL + m - inL + 1, preR, m + 1, inR);
        return root;
    }

}
