package newhot;


import java.util.LinkedList;
import java.util.Queue;

public class newhot994_腐烂的橘子 {

    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length < 1) {
            return 0;
        }
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int res = 0;
        while (fresh > 0 && !queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int m = poll[0];
                int n = poll[1];
                if (m > 0 && grid[m - 1][n] == 1) {
                    grid[m - 1][n] = 2;
                    fresh--;
                    queue.offer(new int[]{m - 1, n});
                }
                if (m < grid.length - 1 && grid[m + 1][n] == 1) {
                    grid[m + 1][n] = 2;
                    fresh--;
                    queue.offer(new int[]{m + 1, n});
                }
                if (n > 0 && grid[m][n - 1] == 1) {
                    grid[m][n - 1] = 2;
                    fresh--;
                    queue.offer(new int[]{m, n - 1});
                }
                if (n < grid[0].length - 1 && grid[m][n + 1] == 1) {
                    grid[m][n + 1] = 2;
                    fresh--;
                    queue.offer(new int[]{m, n + 1});
                }
            }
        }
        return fresh == 0 ? res : -1;
    }

}