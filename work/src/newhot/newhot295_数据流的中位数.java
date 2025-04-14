package newhot;

import java.util.PriorityQueue;

public class newhot295_数据流的中位数 {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public newhot295_数据流的中位数() {
        // 初始化一个大顶推，保存较小的一半
        minHeap = new PriorityQueue<>((o1,o2) -> o2 - o1);
        // 初始化一个小顶推，保存较大的一半
        maxHeap = new PriorityQueue<>((o1,o2) -> o1 - o2);
    }

    public void addNum(int num) {
        // 需要保证大顶推peek是较小那部分的最大值，小顶堆同理。所以每次插入元素就需要重新构建下两个堆
        if (minHeap.size() == maxHeap.size()) {
            // 优先放入小顶堆（需要借助大顶推来过一遍,就是找num和大顶堆中的最大值，放入小顶堆）
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        } else {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0d;
        } else {
            // 因为优先放入的是小顶堆
            return minHeap.peek();
        }
    }

}