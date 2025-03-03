package leetcode100;


/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * https://leetcode.cn/problems/rotate-image/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot48_旋转图像 {

    /**
     * 4个为一组[i][j]-[j][n-1-i]-[n-1-i][n-1-j]-[n-1-j][i]-[i][j]
     * 时间复杂度：O(n方)
     * 空间复杂度：O(1)
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length < 2) {
            return;
        }
        int n = matrix.length;
        // i相当于遍历的外圈数
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                // 交换元素
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
    }

}
