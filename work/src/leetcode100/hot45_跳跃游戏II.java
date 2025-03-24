package leetcode100;

import java.util.Arrays;

/**
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 *
 * https://leetcode.cn/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class hot45_跳跃游戏II {

    /**
     * 贪心算法，从右往左找最远能到达目的地的地方（实现上从左往右遍历）
     * 时间复杂度：O(n方)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int step = 0;
        int position = nums.length - 1;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                // 找最远的能到position的点
                if (i + nums[i] >= position) {
                    position = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }

    /**
     * 贪心算法，每次选择能达到最远的一个边界，到达边界时step+1
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * 这个不太好理解
     *
     * @param nums
     * @return
     */
    public int method2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        // 能跳到的边界
        int end = 0;
        int step = 0;
        // 记录当前能到的最大位置
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 这里相当于遍历上一步所能到的最远地方
            max = Math.max(max, i + nums[i]);
            // 到了上一步能到达的最大边界，才去更新边界
            if (i == end) {
                end = max;
                step++;
            }
        }
        return step;
    }

    /**
     * dp
     * 时间复杂度：O(n方)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @return
     */
    public int method1(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int n = nums.length;
        // 初始化dp数组
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        // 只需要遍历到倒数第二个元素
        for (int i = 0; i < n - 1; i++) {
            int step = nums[i];
            for (int j = i + 1; j < n && j <= i + step; j++) {
                // 上一步跳过来+1 or 本身
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[n - 1];
    }

}
