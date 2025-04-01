package offer;

import utils.TreeNode;

import java.util.Stack;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *
 * https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?tpId=13&tqId=23253&sourceUrl=
 *
 */
public class offer36_二叉搜索树与双向链表 {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        // 先找到res也可以提前用left找好res
        TreeNode res = null;
        // 记录上一节点
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || pRootOfTree != null) {
            if (pRootOfTree != null) {
                stack.push(pRootOfTree);
                pRootOfTree = pRootOfTree.left;
            } else {
                TreeNode pop = stack.pop();
                // 只会执行一次
                if (res == null) {
                    res = pop;
                }
                // 构造当前节点与上一节点关系
                if (pre != null) {
                    pre.right = pop;
                    pop.left = pre;
                }
                pre = pop;
                pRootOfTree = pop.right;
            }
        }
        return res;
    }

}
