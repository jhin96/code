package suanfa;

public class QuickSort_快速排序 {

    public void quickSort(int[] nums) {
        helper(nums, 0, nums.length - 1);
    }

    /**
     * 快速排序
     *
     * @param nums
     * @param left
     * @param right
     */
    public void helper(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        // 基准值
        int value = nums[left];

        while (i < j) {
            // 这里必须从右边开始，不然i,j会相遇在错误的地方
            while (i < j && nums[j] >= value) {
                j--;
            }
            while (i < j && nums[i] <= value) {
                i++;
            }
            // 交换i,j
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        // 交换left,i，此时i=j
        nums[left] = nums[i];
        nums[i] = value;

        helper(nums, left, i - 1);
        helper(nums, i + 1, right);
    }

}