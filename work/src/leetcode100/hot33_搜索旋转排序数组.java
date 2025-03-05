package leetcode100;


/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot33_搜索旋转排序数组 {

    /**
     * 二分查找
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            // 将数组分为两组
            if (nums[left] <= nums[mid]) {
                // 左边有序
                // target < nums[mid]不行，要严格限制在左边才行
                if (nums[left] <= target && target < nums[mid]) {
                    // 在左边有序的部分
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 右边有序
                if (nums[right] >= target && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
