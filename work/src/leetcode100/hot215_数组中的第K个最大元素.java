package leetcode100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot215_数组中的第K个最大元素 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2));
    }

    /**
     * 类似快速排序的分治法
     * 将数组分为大于、小于、等于基准数的3个子数组
     * 若大于数组的长度比k大，则递归在大于数组中找
     * 若k大于大于和等于数组的和，则k在小于数组中，递归在小于于数组中找
     * 否则直接返回基准数
     *
     * 时间复杂度：O(n)，长度为n的数组划分操作复杂度为n，每层下去之后复杂度为n/2，所以和为n + n/2 + n/4 + ... = 2n - 1，复杂度为O(n)
     * 空间复杂度：O(logN)，划分函数平均递归深度O(logN)
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0;
        }
        List<Integer> number = new ArrayList<>();
        for (int num : nums) {
            number.add(num);
        }
        return quickSearch(number, k);
    }

    private static int quickSearch(List<Integer> nums, int k) {
        // 随机选择基准数(也可以就选第一个数)
//        Random rand = new Random();
//        int pivot = nums.get(rand.nextInt(nums.size()));
        int pivot = nums.get(0);

        List<Integer> big = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        for (Integer num : nums) {
            if (num > pivot) {
                big.add(num);
            } else if (num < pivot) {
                small.add(num);
            } else {
                equal.add(num);
            }
        }

        // 若大于数组的长度比k大，则递归在大于数组中找
        if (big.size() >= k) {
            return quickSearch(big, k);
        }

        // 若k大于大于和等于数组的和，则k在小于数组中，递归在小于于数组中找
        if (nums.size() - small.size() < k) {
            return quickSearch(small, k - nums.size() + small.size());
        }

        return pivot;
    }
}
