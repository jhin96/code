package leetcode100;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 * https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot581_最短无序连续子数组 {

    /**
     * 相当于分成3部分
     * 交界的right右边都是比right大且升序，所以需要维护一个max，不更新max的时候才能更新right，从左往右遍历
     * left部分相反
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        // 避免最后right没动
        int right = -1;
        for (int i = 0; i < nums.length; i++) {
            // 找最小串，所以要加=
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                // 更新max的时候不动right，所以最后更新的right右边一定升序且大于right
                right = i;
            }
        }

        int min = Integer.MAX_VALUE;
        int left = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] <= min) {
                min = nums[i];
            } else {
                left = i;
            }
        }
        return right - left + 1;
    }

    /**
     * 排序后比较
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @return
     */
    public int method1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int left = 0;
        int right = nums.length - 1;
        while (left <= right && nums[left] == copy[left]) {
            left++;
        }
        while (left <= right && nums[right] == copy[right]) {
            right--;
        }
        // 如果数组本身有序，最后left在right右边
        return right - left + 1;
    }

}
