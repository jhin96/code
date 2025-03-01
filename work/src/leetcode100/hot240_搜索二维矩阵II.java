package leetcode100;


/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot240_搜索二维矩阵II {

    /**
     * 从右上角开始搜索
     * 时间复杂度O(m * n)
     * 空间复杂度O(1)
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix[0].length < 1) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

}