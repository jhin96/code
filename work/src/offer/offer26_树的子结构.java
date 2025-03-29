package offer;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（我们约定空树不是任意一个树的子结构）
 *
 * https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88?tpId=13&tqId=23293&sourceUrl=
 *
 */
public class offer26_树的子结构 {

    /**
     * 递归判断当前节点与子节点
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        // 注意和dfs的判断不同
        // 空树不是任何子结构，有一个为空都不行
        if (root2 == null || root1 == null) {
            return false;
        }
        return dfs(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    /**
     * 判断以root开始是不是子结构
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean dfs (TreeNode root1,TreeNode root2) {
        // 不能同时为空，因为root1还可以有子节点
//        if (root1 == null && root2 == null) {
//            return true;
//        }
//        if (root1 == null || root2 == null) {
//            return false;
//        }
        // root2匹配完成
        if (root2 == null) {
            return true;
        }
        // root1为空了，但是root2不为空
        if (root1 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return dfs(root1.left, root2.left) && dfs(root1.right, root2.right);
        }
        return false;
    }

}
