package newhot;

import java.util.Arrays;
import java.util.Stack;

public class newhot85_最大矩形 {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length < 1) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // 多一行方便初始化
        int[][] arr = new int[m + 1][n];
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = matrix[i - 1][j] == '1' ? arr[i - 1][j] + 1 : 0;
            }
        }
        int res = 0;
        for (int i = 1; i <= m; i++) {
            int[] length = arr[i];
            int[] left = new int[n];
            int[] right = new int[n];
            Stack<Integer> stack = new Stack<>();
            Arrays.fill(right, n);
            for (int j = 0; j < n; j++) {
                while (!stack.isEmpty() && length[stack.peek()] > length[j]) {
                    right[stack.pop()] = j;
                }
                stack.push(j);
            }
            stack.clear();
            Arrays.fill(left, -1);
            for (int j = n - 1; j >= 0; j--) {
                while (!stack.isEmpty() && length[stack.peek()] > length[j]) {
                    left[stack.pop()] = j;
                }
                stack.push(j);
            }
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                tmp = Math.max(tmp, length[j] * (right[j] - left[j] - 1));
            }
            res = Math.max(res, tmp);
        }
        return res;
    }

}
