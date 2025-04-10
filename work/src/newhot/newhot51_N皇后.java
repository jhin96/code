package newhot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class newhot51_N皇后 {

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        List<List<String>> res = new ArrayList<>();
        dfs(new boolean[n][n], 0, res, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return res;
    }

    /**
     *
     *
     * @param board
     * @param index 行索引
     * @param res
     * @param left 左对角线set
     * @param right 右对角线set
     * @param col 列set
     */
    public void dfs(boolean[][] board, int index, List<List<String>> res, Set<Integer> left, Set<Integer> right, Set<Integer> col) {
        if (index == board.length) {
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < board[0].length; j++) {
                    String s = board[i][j] ? "Q" : ".";
                    builder.append(s);
                }
                tmp.add(builder.toString());
            }
            res.add(tmp);
            return;
        }

        // 遍历这一行的每一个位置
        for (int j = 0; j < board[index].length; j++) {
            if (col.contains(j) || left.contains(index - j) || right.contains(index + j)) {
                continue;
            }
            col.add(j);
            left.add(index - j);
            right.add(index + j);
            board[index][j] = true;
            // 这一行放了皇后，递归遍历下一行
            dfs(board, index + 1, res, left, right, col);
            col.remove(j);
            left.remove(index - j);
            right.remove(index + j);
            board[index][j] = false;
        }
    }

}
