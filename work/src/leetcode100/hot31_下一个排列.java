package leetcode100;


/**
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，
 * 那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列
 * （即，其元素按升序排列）。
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * https://leetcode.cn/problems/next-permutation/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot31_下一个排列 {

    public static void main(String[] args) {
        hot31_下一个排列 hot31_下一个排列 = new hot31_下一个排列();
        hot31_下一个排列.nextPermutation(new int[]{2,2,2,2,2,1});
    }

    /**
     * 从后往前找到第一个顺序对[i][i + 1]，[i]<[i+1]
     * 从后往前找第一个>=i的j,交换i与j的元素
     * i之后的元素排序
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0) {
            if (nums[i] < nums[i + 1]) {
                // 找到最后一个>i的，肯定能找到，因为有nums[i + 1] > nums[i]
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        // 交换i,j
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        // i后面的元素重新排序，因为i之后的元素都是降序的（i,i+1是最后一个升序对）
                        // 且j是第一个>i的，所以交换之后j[***i***]括号部分还是降序
                        reverseFromIndex(nums, i + 1);
                        return;
                    }
                }
            }
            i--;
        }
        reverseFromIndex(nums, 0);
    }

    /**
     * 从index开始反转数组
     *
     * @param nums
     * @param index
     */
    public void reverseFromIndex(int[] nums, int index) {
        int right = nums.length - 1;
        while (index < right) {
            int tmp = nums[index];
            nums[index] = nums[right];
            nums[right] = tmp;
            index++;
            right--;
        }
    }

}
