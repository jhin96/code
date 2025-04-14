package newhot;

import java.util.ArrayList;
import java.util.List;

public class newhot215_数组中的第K个最大元素 {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return quickFind(list, k);
    }

    /**
     * 递归寻找第k大，基于快排的思想
     *
     * @param nums
     * @param k
     * @return
     */
    public int quickFind(List<Integer> nums, int k) {
        int pivot = nums.get(0);
        List<Integer> small = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> big = new ArrayList<>();
        for (int num : nums) {
            if (num > pivot) {
                big.add(num);
            } else if (num < pivot) {
                small.add(num);
            } else {
                equal.add(num);
            }
        }
        // 在big里
        if (big.size() >= k) {
            return quickFind(big, k);
        }
        // 在small里
        if (k > big.size() + equal.size()) {
            return quickFind(small, k - big.size() - equal.size());
        }
        return pivot;
    }

}