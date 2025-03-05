package leetcode100;


/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot34_在排序数组中查找元素的第一个和最后一个位置 {

    public static void main(String[] args) {
        hot34_在排序数组中查找元素的第一个和最后一个位置 fuc = new hot34_在排序数组中查找元素的第一个和最后一个位置();
        int[] nums = {5, 7, 7, 8, 8, 10};
        fuc.searchRange(nums, 8);
    }

    /**
     * 先找到第一个元素，再找最后一个元素
     * 空间复杂度：O(1)
     * 时间复杂度：O(logn)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[]{-1, -1};
        }
        // 先找到第一个target
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                // target一定不在mid及左边
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 此时right是最后一个小于target的元素
        int m = right + 1;
        if (m < 0 || m >= nums.length || nums[m] != target) {
            return new int[]{-1, -1};
        }

        // 找到最后一个target
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        // 此时l是第一个大于target的元素
        int n = l - 1;
        if (n < 0 || n >= nums.length || nums[n] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{m, n};
    }

    /**
     * 简化下写法，思想是一样的
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] method1(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[]{-1, -1};
        }
        int first = -1;
        int last = -1;
        int left = 0;
        int right = nums.length - 1;

        // 找第一个
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                first = mid;
                right = mid - 1;
            }
        }

        // 找最后一个
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                last = mid;
                left = mid + 1;
            }
        }
        return new int[]{first, last};
    }

}
