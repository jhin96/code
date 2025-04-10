package newhot;


public class newhot79_单词搜索 {

    /**
     * 需要在exist中进行遍历，而不是dfs中
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length < 1) {
            return word.isEmpty();
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, 0, i , j, new boolean[board.length][board[0].length])) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs (char[][] board, String word, int index, int m, int n, boolean[][] visit) {
        if (index == word.length()) {
            return true;
        }
        if (m < 0 || m >= board.length || n < 0 || n >= board[0].length || visit[m][n] || board[m][n] != word.charAt(index)) {
            return false;
        }
        visit[m][n] = true;
        boolean res = dfs(board, word, index + 1, m - 1, n, visit) ||
                dfs(board, word, index + 1, m + 1, n, visit) ||
                dfs(board, word, index + 1, m, n - 1, visit) ||
                dfs(board, word, index + 1, m, n + 1, visit);
        visit[m][n] = false;
        return res;
    }

}
