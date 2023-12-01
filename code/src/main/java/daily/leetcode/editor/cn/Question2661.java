package daily.leetcode.editor.cn;

import java.util.*;

public class Question2661 {
    public static void main(String[] args) {
        Solution solution = new Question2661().new Solution();
        solution.firstCompleteIndex(
                new int[]{1, 4, 5, 2, 6, 3},
                new int[][]{
                        {4, 3, 5},
                        {1, 2, 6}
                }
        );

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 存储每个点的位置，方便快速计算每行每列已经有多少个格子被点亮了
     * 执行耗时:14 ms,击败了94.39% 的Java用户
     * 内存消耗:59.6 MB,击败了83.18% 的Java用户
     */
    class Solution {
        public int firstCompleteIndex(int[] arr, int[][] mat) {
            int n = mat.length;
            int m = mat[0].length;
            int[][] map = new int[m * n + 1][2];
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    map[mat[i][j]][0] = i;
                    map[mat[i][j]][1] = j;
                }
            }
            int[] l = new int[n];
            int[] r = new int[m];

            for (int i = 0; i < arr.length; i++) {
                if (++l[map[arr[i]][0]] == m) {
                    return i;
                }

                if (++r[map[arr[i]][1]] == n) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}