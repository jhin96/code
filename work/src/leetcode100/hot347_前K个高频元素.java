package leetcode100;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 * https://leetcode.cn/problems/top-k-frequent-elements/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class hot347_前K个高频元素 {

    /**
     * 用map存储个元素出现次数，然后维护一个小顶堆
     * 时间复杂度O(nLogk)，操作堆时间为logk
     * 空间复杂度O(n)
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new int[0];
        }
        // 存入map
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 按照value排序的小根堆，容量为k
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[1])
        );
        for (int key : map.keySet()) {
            int value = map.get(key);
            if (minHeap.size() == k) {
                // 取堆顶，入堆
                int[] peek = minHeap.peek();
                if (value > peek[1]) {
                    minHeap.poll();
                    minHeap.add(new int[]{key, value});
                }
            } else {
                minHeap.add(new int[]{key, value});
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll()[0];
        }
        return res;
    }
}
