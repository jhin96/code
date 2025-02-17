package suanfa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class huisu_n皇后 {

    List<List<String>> res = new ArrayList<>();

    /**
     * 回溯法
     * 时间复杂度：第一行有n种可能，后续每一行-1，则总复杂度为n!，最后结果需要遍历boolean[][]，则总复杂度为O(n! * n方)
     * 空间复杂度O(n方)，最大为boolean[][]使用空间
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        dfs(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), new boolean[n][n]);
        return res;
    }

    /**
     * 行、列、斜对角不能有皇后，可以用3个set表示
     * 行的话将皇后放到该行，该行其他位置就不能有皇后了，不需要额外数组
     * 列用col存储存在皇后的列数
     * 从左往右的对角线性质为j - i不变，可用set保存
     * 从左往右的对角线性质为i + j不变，可用set保存
     *
     * @param index 这是行索引，所以遍历的时候只需要根据列来遍历
     * @param col
     * @param leftDiag
     * @param rightDiag
     *
     */
    public void dfs(int index, HashSet<Integer> col, HashSet<Integer> leftDiag, HashSet<Integer> rightDiag, boolean[][] data) {
        // 结束条件，已经到了最后一行的下一行（最后一行已经放了皇后才会到这一行）
        if (index == data.length) {
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < data.length; i++) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < data.length; j++) {
                    builder.append(data[i][j] ? "Q" : ".");
                }
                ans.add(builder.toString());
            }
            res.add(ans);
            return;
        }

        // 遍历每一列
        for (int j = 0; j < data.length; j++) {
            // 剪枝，列或者对角有皇后了
            if (col.contains(j) || leftDiag.contains(j - index) || rightDiag.contains(index + j)) {
                continue;
            }
            col.add(j);
            leftDiag.add(j - index);
            rightDiag.add(index + j);
            data[index][j] = true;
            dfs(index + 1, col, leftDiag, rightDiag, data);
            // 还原状态
            col.remove(j);
            leftDiag.remove(j - index);
            rightDiag.remove(index + j);
            data[index][j] = false;
        }
    }

}
