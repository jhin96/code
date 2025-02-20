package suanfa;

/**
 * 找出该数组中满足其总和大于等于 target 的长度最小的子数组，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class huadongchuangkou_长度最小的子数组 {

    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int tmp = 0;

        // 思路就是一直加到大于再移动左窗口
        while (right < nums.length) {
            tmp += nums[right];
            while (tmp >= target) {
                // 找等于target需要这个条件
//                if (tmp == target) {
                    min = Math.min(min, right - left + 1);
//                }
                tmp -= nums[left];
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

}
