package leetcode100;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * https://leetcode.cn/problems/move-zeroes/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot283_移动零 {

    /**
     * 双指针，left指向处理好的元素的右端（全是非0）right指向待处理元素的第一个
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                // 将该元素放到left
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
            }
            right++;
        }
    }

    /**
     * 将非0元素左移一位，后续用0填充
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param nums
     */
    public void method2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[cur] = nums[i];
                cur++;
            }
        }
        while (cur < nums.length) {
            nums[cur] = 0;
            cur++;
        }
    }

    /**
     * 碰到0将后面元素迁移一位
     * 空间复杂度O(1)
     * 时间复杂度O(n方)
     *
     * @param nums
     */
    public void method1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        // 记录应该被放到哪里
        int index = nums.length - 1;
        int i = 0;
        // 只需要遍历到倒数第二位
        while (i < index) {
            if (nums[i] == 0) {
                // 整体前移
                for (int j = i; j < index; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[index--] = 0;
            } else {
                // 防止将0移动到当前位
                i++;
            }
        }
    }

}