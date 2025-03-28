package newhot;


import java.util.Deque;
import java.util.LinkedList;

public class newhot239_滑动窗口最大值 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return new int[0];
        }
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int index = 0;
        // 维护一个双端队列，要求元素递减
        Deque<Integer> queue = new LinkedList<>();

        // 初始化滑动窗口
        for (int i = 1 - k, j = 0; j < nums.length; i++, j++) {
            // 判断删除的元素是不是最大元素
            if (i > 0 && !queue.isEmpty() && nums[i - 1] == queue.getFirst()) {
                queue.removeFirst();
            }
            // 添加元素
            while (!queue.isEmpty() && nums[j] > queue.getLast()) {
                queue.removeLast();
            }
            queue.addLast(nums[j]);
            // 从第一个元素开始记录res
            if (i >= 0) {
                res[index++] = queue.getFirst();
            }
        }
        return res;
    }
    
}
