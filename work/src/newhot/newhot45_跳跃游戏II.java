package newhot;

public class newhot45_跳跃游戏II {

    public int jump(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int step = 0;
        int position = nums.length - 1;
        while (position > 0) {
            // 找到能达到position的最远点，所以从左往右遍历
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    // 第一个找到的一定是最远的，那就跳到这个点
                    step++;
                    position = i;
                    break;
                }
            }
        }
        return step;
    }

}
