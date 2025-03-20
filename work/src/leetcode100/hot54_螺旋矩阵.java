package leetcode100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * https://leetcode.cn/problems/spiral-matrix/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class hot54_螺旋矩阵 {

    public static void main(String[] args) {
        hot54_螺旋矩阵 hot54_螺旋矩阵 = new hot54_螺旋矩阵();
        int[][] matrix = {
                {1, 2, 3},
                {5, 6, 7},
                {9, 10, 11}
        };
        List<Integer> integers = hot54_螺旋矩阵.spiralOrder(matrix);
        System.out.println(integers);
    }

    /**
     * 定义打印的边界，然后遍历4条边
     * 时间复杂度：O(mn)
     * 空间复杂度：O(1)
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length < 1) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        // left=right、top=bottom的时候还能打印，只要有>则一整个矩阵都打印完了
        while (true) {
            // 打印第一行
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            if (top > bottom) {
                break;
            }

            // 打印最后一列
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (left > right) {
                break;
            }

            // 打印最后一行
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;
            if (top > bottom) {
                break;
            }

            // 打印第一列
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return res;
    }

}
