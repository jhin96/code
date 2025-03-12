package leetcode100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *
 * https://leetcode.cn/problems/word-search/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot79_单词搜索 {

    public static void main(String[] args) {
        hot79_单词搜索 hot79_单词搜索 = new hot79_单词搜索();
        char[][] board = new char[1][2];
        board[0][0] = 'a';
        board[0][1] = 'b';
        hot79_单词搜索.exist(board, "ba");
    }

    /**
     * 回溯深度优先搜索，这里需要注意外层的遍历在主方法，搜索才需要用到dfs
     * 为了避免重复遍历需要用boolean[][]记录是否遍历过
     * 时间复杂度：O(m*n*3的l次方)，每个需要遍历另外3个方向
     * 空间复杂度：O(m*n)
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if(board == null || board[0] == null) {
            return word.isEmpty();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, 0, i, j, new boolean[board.length][board[0].length])) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean dfs (char[][] board, String word, int index, int i, int j, boolean[][] visit) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
                board[i][j] != word.charAt(index) || visit[i][j]) {
            return false;
        }

        // 上下左右搜索
        visit[i][j] = true;
        boolean res = dfs(board, word, index + 1, i + 1, j, visit) ||
                dfs(board, word, index + 1, i - 1, j, visit) ||
                dfs(board, word, index + 1, i, j + 1, visit) ||
                dfs(board, word, index + 1, i, j - 1, visit);
        visit[i][j] = false;
        return res;
    }

}
