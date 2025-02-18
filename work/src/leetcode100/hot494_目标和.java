package leetcode100;

/**
 * 给你一个非负整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 * https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot494_目标和 {

    public static void main(String[] args) {
        hot494_目标和 test = new hot494_目标和();
        int[] nums = new int[]{2,107,109,113,127,131,137,3,2,3,5,7,11,13,17,19,23,29,47,53};
        System.out.println(test.findTargetSumWays(nums, 1000));
    }

    /**
     * 二维dp
     * nums的总和为sum，前面是减号的数据和为neg，则加号的为sum - neg
     * targrt = sum - neg - neg，所以neg = (sum - target) / 2
     * 题目变成了找组成（sum - target） / 2的方案个数
     * 时间复杂度：O(nums.length * (sum - target))
     * 空间复杂度：O(nums.length * (sum - target))  二维dp数组空间
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < target || (sum - target) % 2 != 0) {
            return 0;
        }
        int neg = (sum - target) / 2;

        // dp数组，表示nums的前i个元素组成j的方案个数
        int[][] dp = new int[nums.length + 1][neg + 1];

        // 初始化
        dp[0][0] = 1;
        // i从1开始，i = 0的情况初始化dp[0][0]就够了
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= neg; j++) {
                int num = nums[i - 1];
                if (num > j) {
                    // 当前元素不能选择，选了之后超过target了
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 选择了之后就是之前没选的方案数量 + 选择的方案（这就是一种，乘上（j - num）的方案数量）
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num];
                }
            }
        }

        return dp[nums.length][neg];
    }

    public int res = 0;

    /**
     * 普通的递归穷举所有可能，耗时长
     *
     * @param nums
     * @param target
     * @return
     */
    public int method(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        addSum(nums, target, 0);
        return res;
    }

    public void addSum(int[] nums, int target, int index) {
        if (index == nums.length && target == 0) {
            res++;
            return;
        }
        if (index >= nums.length) {
            return;
        }
        addSum(nums, target + nums[index], index + 1);
        addSum(nums, target - nums[index], index + 1);
    }

}