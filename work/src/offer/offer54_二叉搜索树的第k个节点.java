package offer;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一棵结点数为n 二叉搜索树，请找出其中的第 k 小的TreeNode结点值。
 *
 * https://www.nowcoder.com/practice/57aa0bab91884a10b5136ca2c087f8ff?tpId=13&tqId=2305268&sourceUrl=
 *
 */
public class offer54_二叉搜索树的第k个节点 {

    public int KthNode (TreeNode proot, int k) {
        if (proot == null) {
            return -1;
        }
        List<Integer> res = new ArrayList<>();
        dfs(proot, res);
        return res.size() >= k && k > 0 ? res.get(k - 1) : -1;
    }

    public void dfs (TreeNode proot, List<Integer> res) {
        if (proot == null) {
            return;
        }
        dfs(proot.left, res);
        res.add(proot.val);
        dfs(proot.right, res);
    }

    /**
     * 借助栈的中序遍历
     *
     * @param proot
     * @param k
     * @return
     */
    public int method1 (TreeNode proot, int k) {
        if (proot == null) {
            return -1;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || proot != null) {
            if (proot != null) {
                stack.push(proot);
                proot = proot.left;
            } else {
                TreeNode pop = stack.pop();
                k--;
                if (k == 0) {
                    return pop.val;
                }
                proot = pop.right;
            }
        }
        return -1;
    }

}
