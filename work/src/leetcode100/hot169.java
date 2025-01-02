package leetcode100;


/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * https://leetcode.cn/problems/majority-element/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot169 {

    /**
     * 可以通过hashmap存储 元素-出现次数 关系，但是空间复杂度较高
     * 还可以排序后取中间元素,nums[nums.length / 2];
     * 摩尔投票：众数+1，其余-1
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        // 初始化时将vote设为0
        int vote = 0;
        int res = 0;
        for (int num : nums) {
            // 每次vote为0时更新res
            if (vote == 0) {
                res = num;
            }
            // 后续是为res就+1，不为res就-1，等减到0就会更新res
            // 众数一开始的vote是0，后续不会低于0
            if (res == num) {
                vote++;
            } else {
                vote--;
            }
        }
        return res;
    }

}
