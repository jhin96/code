package offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个长度为 n 的数组 num 和滑动窗口的大小 size ，找出所有滑动窗口里数值的最大值。
 *
 * https://www.nowcoder.com/practice/1624bc35a45c42c0bc17d17fa0cba788?tpId=13&tqId=23458&sourceUrl=
 *
 */
public class offer59_滑动窗口的最大值 {

    public ArrayList<Integer> maxInWindows (int[] num, int size) {
        if (num == null || num.length < 1 || size == 0) {
            return new ArrayList<>();
        }
        // 需要一个单调递减的双向队列
        Deque<Integer> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1 - size, j = 0; j < num.length; i++, j++) {
            // 去掉上一轮元素
            if (i > 0 && num[i - 1] == queue.getFirst()) {
                queue.removeFirst();
            }
            // 入队并维护递减
            while (!queue.isEmpty() && num[j] > queue.getLast()) {
                queue.removeLast();
            }
            queue.addLast(num[j]);

            // 记录最大值
            if (i >= 0) {
                res.add(queue.getFirst());
            }
        }
        return res;
    }

}
