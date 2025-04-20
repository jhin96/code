package newhot;


public class newhot152_乘积最大子数组 {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int n = nums.length;
        // max、min都是以i结尾的
        int[] max = new int[n];
        // 记录最小值，避免有负数
        int[] min = new int[n];
        max[0] = min[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            max[i] = Math.max(nums[i], Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]));
            min[i] = Math.min(nums[i], Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]));
            res = Math.max(max[i], res);
        }
        return res;
    }

}
