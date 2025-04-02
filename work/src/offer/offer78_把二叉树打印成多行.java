package offer;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个节点数为 n 二叉树，要求从上到下按层打印二叉树的 val 值，同一层结点从左至右输出，每一层输出一行。
 * 将输出的结果存放到一个二维数组中返回。
 *
 * https://www.nowcoder.com/practice/445c44d982d04483b04a54f298796288?tpId=13&tqId=23453&sourceUrl=
 *
 */
public class offer78_把二叉树打印成多行 {

    public ArrayList<ArrayList<Integer>> Print (TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> cur = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode poll = queue.poll();
                cur.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            res.add(cur);
        }
        return res;
    }

}
