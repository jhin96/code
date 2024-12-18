package leetcode100;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * https://leetcode.cn/problems/number-of-islands/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot200 {

    /**
     * 解法就是深度优先搜索
     * 遍历时对每个版块进行深度优先搜索，将陆地变为海洋1->0，遍历所有相邻的就得到了完整的一块
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int res = 0;
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
           return res;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 当前为陆地才遍历
                if (grid[i][j] == '1') {
                    // 这个dfs执行完，相当于找到了[i,j]相连的所有陆地
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 深度优先dfs
     *
     * @param grid
     * @param i
     * @param j
     */
    private void dfs (char[][] grid, int i ,int j) {
        // 边界条件
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        // 陆地变为海洋
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

}
