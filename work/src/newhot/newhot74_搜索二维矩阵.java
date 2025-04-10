package newhot;


public class newhot74_搜索二维矩阵 {

    /**
     * 从右上角开始找
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1) {
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

    /**
     * 两个二分查找
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean method1(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1) {
            return false;
        }
        // 先找列
        int top = 0;
        int bottom = matrix.length - 1;
        while (top <= bottom) {
            int mid = (top + bottom) / 2;
            if (matrix[mid][0] > target) {
                // 肯定不在mid行
                bottom = mid - 1;
            } else if (matrix[mid][0] < target) {
                // 可能在mid，所以后面需要top-1
                top = mid + 1;
            } else {
                return true;
            }
        }
        // 此时target应该在top - 1行，也就是bottom
        int col = top - 1;
        if (col < 0) {
            return false;
        }

        // 再找行
        int left = 0;
        int right = matrix[col].length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[col][mid] > target) {
                right = mid - 1;
            } else if (matrix[col][mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
