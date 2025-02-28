package daily.leetcode.editor.cn;

public class Question37 {
    public static void main(String[] args) {
        Solution solution = new Question37().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 执行耗时:53 ms,击败了58.38% 的Java用户
     * 内存消耗:40.4 MB,击败了19.43% 的Java用户
     */
    class Solution {
        boolean[][] rowUsed = new boolean[9][10];
        boolean[][] colUsed = new boolean[9][10];
        boolean[][][] matrUsed = new boolean[3][3][10];

        public void solveSudoku(char[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    int num = board[i][j] - '0';
                    if (1 <= num && num <= 9) {
                        rowUsed[i][num] = true;
                        colUsed[j][num] = true;
                        matrUsed[i / 3][j / 3][num] = true;
                    }
                }
            }
            // 回溯深搜
            dfs(board, 0, 0);
        }

        private boolean dfs(char[][] board, int row, int col) {
            // 确定边界
            if (col == board[0].length) {
                col = 0;
                row++;
                if (row == board.length) {
                    return true;
                }
            }

            if (board[row][col] == '.') {
                // 尝试填充1~9
                for (int i = 1; i <= 9; i++) {
                    boolean isUsed = rowUsed[row][i] || colUsed[col][i] || matrUsed[row / 3][col / 3][i];
                    if (!isUsed) {
                        rowUsed[row][i] = true;
                        colUsed[col][i] = true;
                        matrUsed[row / 3][col / 3][i] = true;
                        board[row][col] = (char) ('0' + i);
                        if (dfs(board, row, col + 1)) {
                            return true;
                        }
                        // 回溯
                        board[row][col] = '.';
                        rowUsed[row][i] = false;
                        colUsed[col][i] = false;
                        matrUsed[row / 3][col / 3][i] = false;
                    }
                }
            } else {
                return dfs(board, row, col + 1);
            }
            return false;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}