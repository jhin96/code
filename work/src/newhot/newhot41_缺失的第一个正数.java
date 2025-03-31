package newhot;


public class newhot41_缺失的第一个正数 {

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 1;
        }
        int m = nums.length;
        // 将nums[i]放到nums[i] - 1的位置上
        for (int i = 0; i < m; i++) {
            // 需要保证交换的两个元素不相等
            while (nums[i] != i + 1 && nums[i] < nums.length && nums[i] > 0 && nums[i] != nums[nums[i] - 1]) {
                int tmpA = nums[i];
                int tmpB = nums[nums[i] - 1];
                nums[nums[i] - 1] = tmpA;
                nums[i] = tmpB;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return m + 1;
    }

}
