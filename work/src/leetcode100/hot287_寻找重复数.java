package leetcode100;


/**
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 *
 * https://leetcode.cn/problems/find-the-duplicate-number/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot287_寻找重复数 {

    /**
     * 类似环形链表，如1342与索引建立指向为0-1,1-3,2-4,3-2，遍历之后就到了4-null，这是没有环的，有重复数字就肯定会出现环
     * 这里[]相当于指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        // 相遇的地方不一定是起点
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // 从起点开始相遇则为重复数字
        int start = 0;
        while (start != slow) {
            start = nums[start];
            slow = nums[slow];
        }
        return start;
    }

    /**
     * 修改数组，将nums[i]放到nums[nums[i]]
     * 需要注意交换元素，以及交换的两个元素不能相等
     *
     * @param nums
     * @return
     */
    public int method1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i && nums[i] != nums[nums[i]]) {
                int a = nums[nums[i]];
                int b = nums[i];
                nums[nums[i]] = b;
                nums[i] = a;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return nums[i];
            }
        }
        return 0;
    }

}