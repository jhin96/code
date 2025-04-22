package newhot;

public class newhot136_只出现一次的数字 {

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

}
