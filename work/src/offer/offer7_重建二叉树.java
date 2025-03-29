package offer;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 定节点数为 n 的二叉树的前序遍历和中序遍历结果，请重建出该二叉树并返回它的头结点。
 *
 * https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tqId=23282&sourceUrl=
 *
 */
public class offer7_重建二叉树 {

    /**
     * 递归构建左右子树，注意索引
     *
     * @param preOrder
     * @param vinOrder
     * @return
     */
    public TreeNode reConstructBinaryTree (int[] preOrder, int[] vinOrder) {
        if (preOrder == null || vinOrder== null) {
            return null;
        }
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < vinOrder.length; i++) {
            inorderMap.put(vinOrder[i], i);
        }
        return dfs(inorderMap, preOrder, 0, preOrder.length - 1, vinOrder, 0, vinOrder.length - 1);
    }

    public TreeNode dfs (Map<Integer, Integer> inorderMap, int[] preOrder, int preStart, int preEnd, int[] vinOrder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preStart]);
        int index = inorderMap.get(root.val);
        root.left = dfs(inorderMap, preOrder, preStart + 1, preStart + index - inStart, vinOrder, inStart, index - 1);
        root.right = dfs(inorderMap, preOrder, preStart + index - inStart + 1, preEnd, vinOrder, index + 1, inEnd);
        return root;
    }

}
