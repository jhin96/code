package newhot;

import java.util.ArrayList;
import java.util.List;

public class newhot54_螺旋矩阵 {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length < 1) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        // 定义上下左右边界
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            if (top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (left > right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;
            if (top > bottom) {
                break;
            }
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
