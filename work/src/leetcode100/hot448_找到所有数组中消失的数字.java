package leetcode100;


import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 *
 * https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot448_找到所有数组中消失的数字 {

    public static void main(String[] args) {
        hot448_找到所有数组中消失的数字 fuc = new hot448_找到所有数组中消失的数字();
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> disappearedNumbers = fuc.findDisappearedNumbers(nums);
        System.out.println(disappearedNumbers);
    }

    /**
     * 借助一个辅助数组吧
     * 空间、时间复杂度O(n)
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new ArrayList<>();
        }
        int[] tmp = new int[nums.length];
        for (int num : nums) {
            if (num <= nums.length) {
                tmp[num - 1] = num;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] != i + 1) {
                res.add(i + 1);
            }
        }

        return res;
    }

    /**
     * 直接在原数组将i放到i - 1不太行，因为交换后i - 1的元素就没办法移动了
     * 但是可以用while条件防止死循环（两边只要有一个符合条件就不会换，不加while 4233 这种会一直换）
     * 空间复杂度O(1)
     * 时间复杂度O(n)，while多次执行，但是次数是线性的，不影响O(n)
     *
     * @param nums
     * @return
     */
    public List<Integer> method1(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new ArrayList<>();
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] <= nums.length && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                // 将nums[i]防止到nums[nums[i] - 1]
                int tmpA = nums[i];
                int tmpB = nums[nums[i] - 1];
                // 此时nums[i]变了，不能这么写
//                nums[nums[i] - 1] = tmp;
                nums[nums[i] - 1] = tmpA;
                nums[i] = tmpB;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }

        return res;
    }

}