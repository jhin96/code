package leetcode100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 *
 * https://leetcode.cn/problems/sliding-window-maximum/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot239_滑动窗口最大值 {

    /**
     * 定义一个单调递减的队列，保证队头就是最大元素
     * 关键就在于出队的元素是不是唯一最大值，队列就可以不用考虑这个问题，队头是出队元素的话就直接出队就行
     * 队头不是出队元素则对结果没影响
     * 时间复杂度O(n)
     * 空间复杂度O(k)
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new int[0];
        }
        int n = nums.length;
        int[] res = new int[n - k + 1];
        // 双端队列
        Deque<Integer> deque = new LinkedList<>();
        // 初始化队列相当于窗口尾部在nums[0]
        for(int i = 1 - k, j = 0; j < nums.length; i++, j++) {
            // 队头出队，关键点，如果出队元素是最大值则出队（出队一个就行，这样不用考虑是不是唯一的），因为多个最大值只会出一个
            if (i > 0 && nums[i - 1] == deque.peekFirst()) {
                deque.removeFirst();
            }

            // 队尾入队维护队列递减
            while (!deque.isEmpty() && nums[j] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.addLast(nums[j]);
            if (i >= 0) {
                res[i] = deque.peekFirst();
            }
        }
        return res;
    }

    /**
     * 每轮更新结果，如果出去的元素是最大值，则重新计算；不是最大值则直接取max(max(i -1), add)
     * 超时
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] method1(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new int[0];
        }
        int n = nums.length;
        int[] res = new int[n - k + 1];
        // 找到前k个的最大值
        res[0] = getMax(nums, 0, k - 1);

        // 遍历滑动窗口
        for (int i = 1; i <= n - k; i++) {
            int addNum = nums[i + k - 1];
            int delNum = nums[i - 1];
            if (delNum == res[i - 1]) {
                // 可能是唯一最大值，所以需要计算
                res[i] = getMax(nums, i, i + k - 1);
            } else {
                res[i] = Math.max(res[i - 1], addNum);
            }
        }
        return res;
    }

    public int getMax(int[] nums, int left, int right) {
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

}