package leetcode100;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值的层序遍历。（即逐层地，从左到右访问所有节点）。
 *
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot102_二叉树的层序遍历 {

    /**
     * 借助一个辅助队列
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)，完全二叉树最后一层是n/2个节点
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                size--;
            }
            res.add(list);
        }
        return res;
    }

}
