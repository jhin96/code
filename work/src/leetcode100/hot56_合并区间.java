package leetcode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * https://leetcode.cn/problems/merge-intervals/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot56_合并区间 {

    /**
     * 时间复杂度：O(nlogn)，排序时间为nlogn
     * 空间复杂度：O(n)，排序的栈为logn，到那时辅助list为n
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        // 维护当前这个范围
        for (int i = 1; i < intervals.length; i++) {
            int[] now = list.get(list.size() - 1);
            int left = intervals[i][0];
            int right = intervals[i][1];
            // 与当前最后一个边界对比，不能合并
            if (left > now[1]) {
                list.add(intervals[i]);
            } else {
                // 重新计算右边界(左边界不用算，前面的左边界一定小一些)
                right = Math.max(right, now[1]);
                list.get(list.size() - 1)[1] = right;
            }
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }
        return res;
    }

}
