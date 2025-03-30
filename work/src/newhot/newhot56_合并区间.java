package newhot;

import java.util.*;

public class newhot56_合并区间 {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        // 维护当前区间
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int now = intervals[i][0];
            if (right >= now) {
                // 可以合并
                right = Math.max(right, intervals[i][1]);
            } else {
                // 不能合并
                list.add(new int[]{left, right});
                left = now;
                right = intervals[i][1];
            }
        }
        // 处理最后一组
        list.add(new int[]{left, right});

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }
        return res;
    }

}
