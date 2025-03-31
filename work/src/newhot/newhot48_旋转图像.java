package newhot;


public class newhot48_旋转图像 {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length < 2) {
            return;
        }
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                // 四个角交换
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n- i - 1];
                matrix[j][n- i - 1] = tmp;
            }
        }
    }

}
