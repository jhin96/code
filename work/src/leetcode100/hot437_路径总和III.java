package leetcode100;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * https://leetcode.cn/problems/path-sum-iii/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot437_路径总和III {

    public static void main(String[] args) {
        hot437_路径总和III hot437_路径总和III = new hot437_路径总和III();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(3);
        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;
        node5.right = node6;
        int i = hot437_路径总和III.pathSum(node1, 3);
        System.out.println(i);
    }

    public int res = 0;

    /**
     * 采用前缀和
     *
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        // 不添加这个1,2,3找6这种会输出0
        map.put(0, 1);
        helper(root, 0, targetSum, map);
        return res;
    }

    /**
     * 深度优先遍历
     *
     * @param root
     * @param cur
     * @param target
     * @param map
     */
    public void helper(TreeNode root, Integer cur, int target, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        cur += root.val;
        if (map.containsKey(cur - target)) {
            res += map.get(cur - target);
        }
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        helper(root.left, cur, target, map);
        helper(root.right, cur, target, map);
        // 类似回溯的思想，回上个节点时删除这个节点(相当于每条路径维护自己的cur和map)
        map.put(cur, map.get(cur) - 1);
    }

    /**
     * 总的求和方法，相当于只求以root为根节点的结果，但是每一个节点都能当成根节点计算pathSum
     * 时间复杂度：O(n方)对每个节点的时间复杂度是n，然后n个节点都能做根节点
     * 空间复杂度：O(n)栈的深度（每个递归调用都是独立的，空间复杂度是由最深的递归调用链决定的）
     *
     * @param root
     * @param targetSum
     * @return
     */
    public int method1(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        // 以当前节点为根的解法
        int rootNum = dfs(root, targetSum, 0);
        // 以左、右子树为根的解法（路径可以从任一节点开始）
        int leftNum = method1(root.left, targetSum);
        int rightNum = method1(root.right, targetSum);
        return rootNum + leftNum + rightNum;
    }

    /**
     * 计算以当前节点为根节点时，有多少种可能
     *
     * @param root
     * @param targetSum
     * @param current
     */
    public int dfs(TreeNode root, int targetSum,int current) {
        if (root == null) {
            return 0;
        }
        int pathNum = 0;
        current += root.val;
        if (current == targetSum) {
            pathNum++;
        }
        // 递归遍历左右子树
        int left = dfs(root.left, targetSum, current);
        int right = dfs(root.right, targetSum, current);
        return pathNum + left + right;
    }

}
