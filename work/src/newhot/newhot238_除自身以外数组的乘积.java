package newhot;


public class newhot238_除自身以外数组的乘积 {

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 1) {
            return nums;
        }
        int[] left = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        int[] right = new int[nums.length];
        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < left.length; i ++ ) {
            left[i] *= right[i];
        }
        return left;
    }

}
