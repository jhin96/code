package leetcode100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 *
 * https://leetcode.cn/problems/rotting-oranges/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class hot994_腐烂的橘子 {

    /**
     * 广度优先bfs写法，类似中序遍历借助队列实现
     * 时间复杂度：O(m * n)
     * 空间复杂度：O(m * n)
     *
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        // 记录新鲜橘子数量
        int fresh = 0;
        int res = 0;
        // 辅助队列记录位置，需要记录size（相当于中序遍历的每层）
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        // 记录腐烂橘子的位置
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // bfs，需要有fresh>0才能算出最小的时间
        while (fresh > 0 && !queue.isEmpty()) {
            // 每层相应于过一分钟
            res++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] poll = queue.poll();
                int i = poll[0];
                int j = poll[1];
                // 四个方向，注意越界
                if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    fresh--;
                    queue.offer(new int[]{i - 1, j});
                }
                if (i + 1 < m && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    fresh--;
                    queue.offer(new int[]{i + 1, j});
                }
                if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    fresh--;
                    queue.offer(new int[]{i, j - 1});
                }
                if (j + 1 < n && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    fresh--;
                    queue.offer(new int[]{i, j + 1});
                }
            }
        }
        return fresh == 0 ? res : -1;
    }

}
