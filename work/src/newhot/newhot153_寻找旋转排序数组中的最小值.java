package newhot;


public class newhot153_寻找旋转排序数组中的最小值 {

    public int findMin(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            // 有序(条件加了=一定会在这里return)
            if (nums[left] <= nums[mid] && nums[mid] <= nums[right]) {
                return nums[left];
            } else if (nums[left] <= nums[mid]) {
                // 左边有序
                left = mid + 1;
            } else {
                // 右边有序，mid无法排除
                right = mid;
            }
        }
        return -1;
    }

    /**
     * 必须先判断右边，nums就是有序的应该先处理右边，有序的情况下先动left指针会把最小值排除出去
     *
     * @param nums
     * @return
     */
    public int method1(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                // 右边有序，但是不能排除mid
                right = mid;
            } else {
                // 左边有序，右边无序
                // 如果全是有序的，上一步就返回了，不会走到这一步把左边排除
                left = mid + 1;
            }
        }
        // 此时left=right
        return nums[left];
    }

}
