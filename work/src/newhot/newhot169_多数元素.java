package newhot;

public class newhot169_多数元素 {

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        // 摩尔投票
        int res = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            if (res == num) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }

}
