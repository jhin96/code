package leetcode100;


/**
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 *
 * https://leetcode.cn/problems/single-number/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot136_只出现一次的数字 {

    /**
     * 异或运算
     * 性质：0 ^ a = a; a ^ a = 0; 满足交换律、结合律
     * 时间复杂度O(n)，空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        // 这里定义成0，从nums[0]开始也行，更好理解
        int single = nums[0];
        for (int i = 1; i < nums.length; i++) {
            single ^= nums[i];
        }
        return single;
    }

}