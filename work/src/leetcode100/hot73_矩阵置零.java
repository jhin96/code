package leetcode100;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用原地算法。
 *
 * https://leetcode.cn/problems/set-matrix-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class hot73_矩阵置零 {

    /**
     * 用第一行第一列来记录是否出现0，最后还原第一行第一列
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(1)
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length < 1) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean rowOne = false;
        boolean colOne = false;
        // 第一列第一行时候出现0
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                colOne = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                rowOne = true;
                break;
            }
        }
        // 不需要从0开始遍历是因为已经将第一行第一列受影响的数都变成0了
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 处理第一行第一列
        if (rowOne) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (colOne) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    /**
     * 记录0出现的行、列
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(m+n)
     *
     * @param matrix
     */
    public void method1(int[][] matrix) {
        if (matrix == null || matrix.length < 1) {
            return;
        }
        // 行，列置0的数据
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row.contains(i) || col.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
