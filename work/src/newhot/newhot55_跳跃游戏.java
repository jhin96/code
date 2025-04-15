package newhot;

public class newhot55_跳跃游戏 {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 1) {
            return true;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max >= i) {
                max = Math.max(max, i + nums[i]);
            }
        }
        return max >= nums.length - 1;
    }

}
