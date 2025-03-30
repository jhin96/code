package newhot;


public class newhot189_轮转数组 {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return;
        }
        // 处理k
        k = k % nums.length;
        // 整个翻转后翻转两个部分
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

}
