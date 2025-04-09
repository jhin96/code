package newhot;

public class newhot200_岛屿数量 {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    transfer(grid, i, j);
                }
            }
        }
        return res;
    }

    /**
     * 将和这块陆地链接的地都变成水
     *
     * @param grid
     * @param i
     * @param j
     */
    public void transfer(char[][] grid, int i, int j) {
        // 需要加一个0判断，不然会stackoverfolw
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        transfer(grid, i - 1, j);
        transfer(grid, i + 1, j);
        transfer(grid, i, j - 1);
        transfer(grid, i, j + 1);
    }

}
