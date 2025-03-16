package leetcode100;

/**
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 *
 * https://leetcode.cn/problems/sort-colors/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot75_颜色分类 {

    /**
     * 荷兰国旗问题
     * 定义左右指针，遍历nums，0移动到左指针，2移动到右指针
     * left代表下一个0应该在的位置，right代表下一个2应该在的位置
     * 空间复杂度：O(1)
     * 时间复杂度：O(n)
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while (index <= right) {
            if (nums[index] == 0) {
                // 这里index++是因为知道了当前就是0，已经处理完了
                swap(nums, index, left);
                left++;
                index++;
            } else if (nums[index] == 2) {
                // 这里index不需要加是因为不知道换到这里的是多少，需要继续处理
                swap(nums, index, right);
                right--;
            } else {
                // nums[index] == 1
                index++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 快速排序
     *
     * @param nums
     * @param left
     * @param right
     */
    public void dfs (int[] nums, int left, int right) {
        if (right <= left) {
            return;
        }
        int l = left;
        int r = right;
        int standard = nums[left];
        while (left < right) {
            // 从右往左找第一个小于基准元素
            while (left < right && nums[right] >= standard) {
                right--;
            }
            // 从左右找第一个大于基准元素
            while (left < right && nums[left] <= standard) {
                left++;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        // 此时left=right
        nums[l] = nums[left];
        nums[left] = standard;
        dfs(nums, l, right - 1);
        dfs(nums, right + 1,  r);
    }

}
