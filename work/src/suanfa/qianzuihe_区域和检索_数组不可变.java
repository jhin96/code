package suanfa;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.logging.Level;

/**
 *
 * 给定一个整数数组  nums，处理以下类型的多个查询:
 * 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
 * 实现 NumArray 类：
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，
 * 包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
 *
 * https://leetcode.cn/problems/range-sum-query-immutable/description/
 *
 */
public class qianzuihe_区域和检索_数组不可变 {

    public int[] sum;

    /**
     * 正常遍历虽然复杂度是O(n)，但是多次执行耗时长，考虑前缀和
     *
     *
     * @param nums
     */
    public qianzuihe_区域和检索_数组不可变(int[] nums) {
        sum = new int[nums.length + 1];
        // 初始化，其实不用写
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] += sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        if (left > right) {
            return 0;
        }
        return sum[right + 1] - sum[left];
    }

}
