package suanfa;


/**
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 *
 * https://leetcode.cn/problems/search-a-2d-matrix/description/
 *
 */
public class search_搜索二维矩阵 {

    /**
     * 先找到所在的列，找到小于等于target的最后一列，再在这个列上二分查找
     * 时间复杂度O(logm + logn)
     * 空间复杂度：O(1)
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix[0].length < 1) {
            return false;
        }
        // 先找到所在的列、行
        int i = 0;
        int j = matrix.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (matrix[mid][0] < target) {
                // i = mid会死循环，比如1,10找9（下一循环更新后，j会在i前）
                i = mid + 1;
            } else if (matrix[mid][0] > target) {
                j = mid - 1;
            } else {
                return true;
            }
        }
        // 此时j才是指向小于等于target的最后一行
        int row = j;
        if (row < 0) {
            return false;
        }

        int left = 0;
        int right = matrix[row].length - 1;
        while (left <= right) {
            int midVal = (left + right) / 2;
            if (matrix[row][midVal] < target) {
                left = midVal + 1;
            } else if (matrix[row][midVal] > target) {
                right = midVal - 1;
            } else {
                return true;
            }
        }

        return false;
    }

}