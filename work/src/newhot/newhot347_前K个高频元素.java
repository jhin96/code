package newhot;

import java.util.*;

public class newhot347_前K个高频元素 {

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 构建一个容量为k的小顶堆
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[1])
        );
        for (int key : map.keySet()) {
            Integer value = map.get(key);
            if (minHeap.size() == k) {
                int[] peek = minHeap.peek();
                if (peek[1] < value) {
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

    /**
     * 借助大根堆
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] method1(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (e1, e2) -> Integer.compare(e2.getValue(), e1.getValue())
        );

        for (Map.Entry<Integer, Integer> entrySet : map.entrySet()) {
            maxHeap.add(entrySet);
        }
        int[] res = new int[k];
        int index = 0;
        while (k > 0) {
            res[index++] = maxHeap.poll().getKey();
            k--;
        }
        return res;
    }

}