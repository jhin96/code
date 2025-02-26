package leetcode100;


import utils.TreeNode;

/**
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 *
 * https://leetcode.cn/problems/house-robber-iii/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot337_打家劫舍III {

    /**
     * int[]用来存储当前节点偷或者不偷的两种结果，0是偷，1是不偷
     * 时间复杂度O(n)，最坏情况下二叉树为链表
     * 空间复杂度O(n)，最坏情况下二叉树为链表
     *
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        int[] dfs = dfs(root);
        return Math.max(dfs[0], dfs[1]);
    }

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        // 偷当前节点
        int rob = root.val + left[1] + right[1];
        // 不偷当前节点，偷左右（需要找到maxLeft和maxRight）
        int noRob = Math.max(left[0], left[1]) +  Math.max(right[0], right[1]);
        return new int[]{rob, noRob};
    }

    /**
     * 不能用层序遍历然后求每层的和，转化为一维dp的打家劫舍，因为对于相邻的两层节点，第一层右边的节点和第二层左边的节点完全可以求和
     * 思路就是不偷该节点则是左 + 右，偷该节点就是该节点 + 2个左子 + 2个右子
     * 超时
     *
     * @param root
     * @return
     */
    public int method1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // 偷该节点
        int stealNode = root.val;
        if (root.left != null) {
            stealNode += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            stealNode += rob(root.right.left) + rob(root.right.right);
        }
        // 不偷该节点
        int notStealNode = rob(root.left) + rob(root.right);
        return Math.max(stealNode, notStealNode);
    }

}