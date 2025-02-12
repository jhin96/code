package leetcode100;

/**
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 * https://leetcode.cn/problems/maximal-square/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot221_最大正方形 {

    public static void main(String[] args) {
        char[][] matrix = new char[1][1];
        matrix[0][0] = '1';
        System.out.println(maximalSquare(matrix));
    }

    /**
     * 动态规划，dp[i][j]标识以i,j为右下角，只包含1的最大正方形边长
     * 时间复杂度O(mn)，二层for循环遍历时间为m * n
     * 空间复杂度O(mn)，dp[i][j]占用空间为m * n
     *
     * @param matrix
     * @return
     */
    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }

        int res = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // 为左边，上边，左上角三个边长的最小值 + 1，min(上, 左, 左上) + 1
                        // 上, 左, 左上 这三个的最小值的话，其左上的矩阵一定可以找到以这个最小值为边长的全为1的矩阵，并且+1的话增加的一列一定符合要求
                        // 可结合图片细想
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    // 更新res
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res * res;
    }

}
