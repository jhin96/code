package leetcode100;

import utils.TreeNode;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
 *
 * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class hot108_将有序数组转换为二叉搜索树 {

    public static void main(String[] args) {
        hot108_将有序数组转换为二叉搜索树 hot108_将有序数组转换为二叉搜索树 = new hot108_将有序数组转换为二叉搜索树();
        hot108_将有序数组转换为二叉搜索树.sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }

    /**
     * 递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(logn)，递归栈的深度
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        return dfs(nums, 0, nums.length - 1);
    }

    public TreeNode dfs (int[] nums, int start, int end) {
        if (start > end || start < 0 || start >= nums.length || end < 0 || end >= nums.length) {
            return null;
        }
        int rootIndex = (start + end + 1) / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = dfs(nums, start, rootIndex - 1);
        root.right = dfs(nums, rootIndex + 1, end);
        return root;
    }

}
