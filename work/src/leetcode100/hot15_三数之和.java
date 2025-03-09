package leetcode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * https://leetcode.cn/problems/3sum/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot15_三数之和 {

    public static void main(String[] args) {
        hot15_三数之和 hot15_三数之和 = new hot15_三数之和();
        hot15_三数之和.threeSum(new int[]{-1,0,1,2,-1,-4});
    }

    /**
     * 排序后进行遍历，通过双指针找到另外两个元素
     * 空间复杂度：O(logn)，快排时间复杂度，最差O(n)
     * 时间复杂度：O(n方)，双指针找l和r，快排是logn
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // 后续都是大于0的
            if (nums[i] > 0) {
                break;
            }
            // 剪枝
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 移动左右指针
                    while (right > 0 && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // 这行要有，不然那上面的条件可能进不去
                    right--;
                    while (left < nums.length - 1 && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return res;
    }

}
