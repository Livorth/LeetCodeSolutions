package daily.leetcode.editor.cn;

import java.util.*;

public class Question1878 {
    public static void main(String[] args) {
        Solution solution = new Question1878().new Solution();
//        solution.getBiggestThree(new int[][]{
//                {1,2,3},
//                {4,5,6},
//                {7,8,9},
//        });
//        solution.getBiggestThree(new int[][]{
//                {3, 4, 5, 1, 3},
//                {3, 3, 4, 2, 3},
//                {20, 30, 200, 40, 10},
//                {1, 5, 5, 4, 1},
//                {4, 3, 2, 2, 5},
//        });
        solution.getBiggestThree(new int[][]{
                {7, 7, 7}
        });
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int a1 = -1;
        int a2 = -1;
        int a3 = -1;

        public int[] getBiggestThree(int[][] grid) {
            // 往左上角走的前缀和
            int[][] sum1 = new int[grid.length][grid[0].length];
            // 往右上角走的前缀和
            int[][] sum2 = new int[grid.length][grid[0].length];
            // 遍历求前缀和
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        sum1[i][j] = sum1[i - 1][j - 1] + grid[i][j];
                    } else {
                        sum1[i][j] = grid[i][j];
                    }
                    if (i - 1 >= 0 && j + 1 < grid[i].length) {
                        sum2[i][j] = sum2[i - 1][j + 1] + grid[i][j];
                    } else {
                        sum2[i][j] = grid[i][j];
                    }
                }
            }

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    int k = 1;
                    setNewMaxThree(grid[i][j]);
                    while (i - k >= 0 && j - k >= 0 && i + k < grid.length && j + k < grid[i].length) {
                        int size = 0;
                        size += sum1[i][j + k] - sum1[i - k][j]; // +1右
                        size += sum1[i + k][j] - sum1[i][j - k]; // +1下
                        size += sum2[i][j - k] - sum2[i - k][j]; // +1左
                        size += sum2[i + k][j] - sum2[i][j + k]; // +1下
                        // 补到+1上下左右，其中已经有两个下，并少一个上了
                        size = size - grid[i + k][j] + grid[i - k][j];
                        setNewMaxThree(size);
                        k++;
                    }
                }
            }
            ArrayList<Integer> resList = new ArrayList<>();
            if (a1 != -1) resList.add(a1);
            if (a2 != -1) resList.add(a2);
            if (a3 != -1) resList.add(a3);
            int[] res = new int[resList.size()];
            for (int i = 0; i < resList.size(); i++) {
                res[i] = resList.get(i);
            }
            return res;
        }

        void setNewMaxThree(int k) {
            if (k >= a1) {
                if (k == a1) return;
                a3 = a2;
                a2 = a1;
                a1 = k;
                return;
            }
            if (k >= a2) {
                if (k == a2) return;
                a3 = a2;
                a2 = k;
                return;
            }
            if (k >= a3) {
                if (k == a3) return;
                a3 = k;
                return;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}