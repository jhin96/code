package newhot;

public class newhot283_移动零 {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        // 记录非0位置
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void method1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        // left只想非0的右边，right指向待处理的第一个
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
            }
            right++;
        }
    }

}
