package leetcode100;


import java.util.Arrays;
import java.util.Stack;

/**
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * https://leetcode.cn/problems/maximal-rectangle/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot85_最大矩形 {

    /**
     * 将每一行作为基准，转化为求柱状图中的最大矩形
     * 时间复杂度：O(m * n)
     * 空间复杂度：O(m * n)
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length < 1) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] array = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
           for (int j = 1; j <= n; j++) {
               // 注意这里0的话就直接是0了
               array[i][j] = matrix[i - 1][j - 1] == '1' ? array[i - 1][j] + 1 : 0;
           }
        }

        int res = 0;
        // 注意这里是n
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];
        Stack<Integer> stack = new Stack<>();
        // 逐行求最大值
        for (int i = 1; i <= m; i++) {
            int[] cur = array[i];
            // 注意这里下标从1开始
            Arrays.fill(left, 0);
            Arrays.fill(right, n + 1);

            stack.clear();
            for (int k = 1; k <= n; k++) {
                while (!stack.isEmpty() && cur[stack.peek()] > cur[k]) {
                    right[stack.pop()] = k;
                }
                stack.push(k);
            }

            stack.clear();
            for (int k = n; k >= 1; k--) {
                while (!stack.isEmpty() && cur[stack.peek()] > cur[k]) {
                    left[stack.pop()] = k;
                }
                stack.push(k);
            }

            int tmp = 0;
            for (int l = 1; l <= n; l++) {
                tmp = Math.max(tmp, cur[l] * (right[l] - left[l] - 1));
            }

            res = Math.max(res, tmp);
        }
        return res;
    }

}
