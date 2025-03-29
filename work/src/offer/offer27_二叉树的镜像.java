package offer;

import utils.TreeNode;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * https://www.nowcoder.com/practice/a9d0ecbacef9410ca97463e4a5c83be7?tpId=13&tqId=1374963&sourceUrl=
 *
 */
public class offer27_二叉树的镜像 {

    public TreeNode Mirror (TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }
        // 需要先存起来
        TreeNode left = Mirror(pRoot.left);
        TreeNode right = Mirror(pRoot.right);
        pRoot.left = right;
        pRoot.right = left;
        return pRoot;
    }

}
