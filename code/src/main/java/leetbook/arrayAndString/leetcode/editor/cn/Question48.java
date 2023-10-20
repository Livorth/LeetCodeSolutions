package daily.leetcode.editor.cn;

public class Question48 {
    public static void main(String[] args) {
        Solution solution = new Question48().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            // 先以对角线（左上-右下）为轴进行翻转
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
            // 再对每一行以中点进行翻转
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n >> 1; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[i][n - 1 - j];
                    matrix[i][n - 1 - j] = tmp;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}