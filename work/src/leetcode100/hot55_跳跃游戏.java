package leetcode100;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 * https://leetcode.cn/problems/jump-game/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot55_跳跃游戏 {

    /**
     * 遍历数组，记录能到的最远的位置
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 1) {
            return true;
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 能到这个点就更新最大值
            if (max >= i) {
                max = Math.max(max, i + nums[i]);
            }
        }
        return max >= nums.length - 1;
    }

    /**
     * 枚举每一格能到的位置
     * 时间复杂度：O(n方)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @return
     */
    public boolean method1(int[] nums) {
        if (nums == null || nums.length < 1) {
            return true;
        }
        boolean[] jump = new boolean[nums.length];
        jump[0] = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (!jump[i]) {
                continue;
            }
            int start = i + 1;
            int end = Math.min(i + nums[i], nums.length - 1);
            for (int j = start; j <= end; j++) {
                jump[j] = true;
            }
        }
        return jump[jump.length - 1];
    }

}
